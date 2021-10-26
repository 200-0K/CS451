import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

class CurvePoints { 
    int[] p0 = new int[2];      // X0, Y0
    int[] p1 = new int[2];      // X1, Y1
    int[] p0dash = new int[2];  // X0', Y0'
    int[] p1dash = new int[2];  // X1', Y1'

    CurvePoints(int[] p0, int[] p1, int[] p0dash, int[] p1dash) {
        this.p0 = p0;
        this.p1 = p1;
        this.p0dash = p0dash;
        this.p1dash = p1dash;
    }
}

public class BezierCurve extends JPanel {
    private BufferedImage image;
    private CurvePoints points;
    private int steps;

    BezierCurve(int[] p0, int[] p1, int[] p0dash, int[] p1dash, int steps) {
        this.points = new CurvePoints(p0, p1, p0dash, p1dash);
        this.steps = steps;
        image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] newPoints = computePointsAtTime(0);
        int oldX = newPoints[0];
        int oldY = newPoints[1];

        for (int i = 1; i < steps; i++) {
            //? System.out.println(oldX + " | " + oldY);
            newPoints = computePointsAtTime((float)i/steps);
            g.drawLine(oldX, oldY, newPoints[0], newPoints[1]);
            oldX = newPoints[0];
            oldY = newPoints[1];
        }

        g.drawImage(image, 0, 0, null);
    }

    private int[] computePointsAtTime(float t) {
        // Using Case 2 --> x0, x1, x0', x1'
        // [t^3 + t^2 + t + 1] * Bézier matrix = Blending functions
        int[] newPoints = new int[2]; // new (x,y)
        for (int i = 0; i < newPoints.length; i++) {
            // (1x4 Matrix(Blending functions)) X (4x1 Matrix(Control & End Points))
            float c0 = (    -pow(t, 3) +  3 * pow(t, 2) - 3 * t + 1)  * points.p0[i];     // [-t^3 +3t^2 -3t +1] * [x or y]0
            float c1 = ( 3 * pow(t, 3) -  6 * pow(t, 2) + 3 * t    )  * points.p1[i];     // [3t^3 -6t^2 +3t]    * [x or y]1
            float c2 = (-3 * pow(t, 3) +  3 * pow(t, 2)            )  * points.p0dash[i]; // [-3t^3 +3t^2]       * [x or y]0'
            float c3 = (     pow(t, 3)                             )  * points.p1dash[i]; // [t^3]               * [x or y]1'
            newPoints[i] = (int)(c0 + c1 + c2 + c3);
        }
        return newPoints;
    }

    private float pow(float a, float b) {
        return (float)Math.pow(a, b);
    }
}
