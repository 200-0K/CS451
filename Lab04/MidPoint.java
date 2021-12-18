import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MidPoint extends JPanel {
    int[][] QColors = {
        {255, 0, 0, 255},   // RED
        {0, 255, 0, 255},   // GREEN
        {0, 0, 255, 255},   // BLUE
        {255, 0, 255, 255}, // MAGENTA
    };
    int size = 600, r, center;
    BufferedImage image;
    WritableRaster raster;

    MidPoint(int r) {
        this.r = r;
        size = Math.max( r*2+10, size );
        center = Math.round(size/2);
        image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        raster = image.getRaster();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawCircle(r, center);

        g.drawImage(image, 0, 0, null);
    }

    private void drawCircle(int r, int center) {
        int p = 1-r;
        int x = 0, y = r;
        raster.setPixel(center, center-y, QColors[0]); // Oct2,3
        raster.setPixel(center-y, center, QColors[1]); // Oct4,5
        raster.setPixel(center, center+y, QColors[2]); // Oct6,7
        raster.setPixel(center+y, center, QColors[3]); // Oct8,1

        while (x < y) {
            if (p < 0) p += 2*x + 3;
            else {
                p += 2*(x-y) + 5;
                y--;
            }
            x++;
            
            // Quarters 1,2
            raster.setPixel(center+x, center-y, QColors[0]); // Clockwise        | Q1-Oct2
            raster.setPixel(center-x, center-y, QColors[1]); // Counterclockwise | Q2-Oct3

            // Quarters 2,3
            raster.setPixel(center-y, center-x, QColors[1]); // Clockwise        | Q2-Oct4
            raster.setPixel(center-y, center+x, QColors[2]); // Counterclockwise | Q3-Oct5

            // Quarters 3,4
            raster.setPixel(center-x, center+y, QColors[2]); // Clockwise        | Q3-Oct6
            raster.setPixel(center+x, center+y, QColors[3]); // Counterclockwise | Q4-Oct7

            // Quarters 4,1
            raster.setPixel(center+y, center+x, QColors[3]); // Clockwise        | Q4-Oct8
            raster.setPixel(center+y, center-x, QColors[0]); // Counterclockwise | Q1-Oct1
        }
    }
}
