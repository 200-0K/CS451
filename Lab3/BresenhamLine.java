import java.awt.*;
import java.awt.image.*;
import java.applet.*;

public class BresenhamLine extends Applet {
    BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    private int x1, x2, y1, y2;

    BresenhamLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        init();
    }

    public void init() {
        setSize(600, 900);
        repaint();
    }

    public void paint(Graphics g) {
        int color[] = {255, 0, 0, 255};
        float dx = Math.abs(x2 - x1);
        float dy = Math.abs(y2 - y1);
        float m = dy/dx;
        if (m > 1) {
            lineLoop(y1, x1, y2, x2, color);
        } else lineLoop(x1, y1, x2, y2, color);

        g.drawImage(image, 0, 0, null);
    }

    private void lineLoop(int x1, int y1, int x2, int y2, int[] color) {
        float dx = Math.abs(x2 - x1);
        float dy = Math.abs(y2 - y1);
        float p = 2*dy-dx;
        raster.setPixel(x1, y1, color);
        for (int k = 1; k <= dx; k++) {
            if (p < 0) {
                x1 = (x1 < x2) ? x1+1 : x1-1;
                p += 2*dy;
            } else {
                x1 = (x1 < x2) ? x1+1 : x1-1;
                y1 = (y1 < y2) ? y1+1 : y1-1;
                p += 2*(dy-dx);
            }
            raster.setPixel(x1, y1, color);
        }
    }
}
