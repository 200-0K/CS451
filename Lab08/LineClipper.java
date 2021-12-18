import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class LineClipper extends JPanel {
    private BufferedImage image;
    private int lines[][];
    private int xmax, xmin, ymax, ymin;

    LineClipper(int screenRes[], int lines[][]) {
        this.lines = lines;
        xmax = 640 + screenRes[0] / 2;
        xmin = 640 - screenRes[0] / 2;
        ymin = 360 - screenRes[1] / 2;
        ymax = 360 + screenRes[1] / 2;
        System.out.println("-- The lines inside are in Black color. Lines clipped are in Red color");
    }

    void drawBorder(Graphics g) {
        g.drawLine(xmax, ymax, xmin, ymax);
        g.drawLine(xmin, ymax, xmin, ymin);
        g.drawLine(xmin, ymin, xmax, ymin);
        g.drawLine(xmax, ymin, xmax, ymax);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        drawBorder(g);
        double p[] = new double[4];
        double q[] = new double[4];

        for (int[] line : lines) {
            double u1 = 0, u2 = 1;
            int x1 = line[0];
            int x2 = line[2];
            int y1 = line[1];
            int y2 = line[3];
            int dx = x2 - x1;
            int dy = y2 - y1;
            p[0] = -dx;
            p[1] = dx;
            p[2] = -dy;
            p[3] = dy;
            q[0] = x1 - xmin;
            q[1] = xmax - x1;
            q[2] = y1 - ymin;
            q[3] = ymax - y1;
            boolean outsiedFlag = false;
            for (int i = 0; i < 4; i++) {
                if (p[i] == 0) { // check if line is inside the boundary
                    if (q[i] < 0) {
                        outsiedFlag = true;
                    }
                } else {
                    double u = q[i] / p[i];
                    if (p[i] < 0) {
                        u1 = Math.max(u, u1);
                    } else {
                        u2 = Math.min(u, u2);
                    }
                }
            }
            outsiedFlag = outsiedFlag || u1 > u2; // if the line is outside; skip
            if (outsiedFlag)
                continue; // check if line was clipped
            if (u1 == 0 && (int) (u2 * dy) == y2 - y1) {
                g.setColor(Color.BLACK);
                g.drawLine(x1, y1, x2, y2);
            } else {
                g.setColor(Color.RED);
                int xx1, yy1, xx2, yy2;
                xx1 = (int) (x1 + u1 * dx);
                yy1 = (int) (y1 + u1 * dy);
                xx2 = (int) (x1 + u2 * dx);
                yy2 = (int) (y1 + u2 * dy);
                g.drawLine(xx1, yy1, xx2, yy2);
            }
        }
        g.drawImage(image, 0, 0, null);
    }
}
