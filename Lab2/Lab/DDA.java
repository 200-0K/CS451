import java.awt.*;
import java.awt.image.*;
import java.applet.*;

public class DDA extends Applet {
    BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    int x1,x2,y1,y2;

    DDA(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        init();
    }

    public void init() {
        setSize(600, 600);
        repaint();
    }
    
    public void paint(Graphics g) {
        int dx, dy;
        int color[] = {255, 0, 0, 255};
        int steps;
        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy)) steps = Math.abs(dx);
        else steps = Math.abs(dy);

        float Xinc = (float) dx/steps;
        float Yinc = (float) dy/steps;
        raster.setPixel(x1, y1, color);

        float x = x1;
        float y = y1;
        System.out.println("X:" + x1 + " y:" + y1);

        for(int k = 1; k <= steps; k++) {
            x+=Xinc;
            y+=Yinc;
            raster.setPixel(Math.round(x), Math.round(y), color);
            System.out.println("X: " + Math.round(x) + " Y:" + Math.round(y));
        }

        g.drawImage(image, 0, 0, null);
    }
}