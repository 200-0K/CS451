import java.awt.*;
import javax.swing.*;

public class Lab3 {
    public static void main(String[] args) {
        drawLine(50, 70, 160, 200);      // Lab Activity
        drawLine(0, 0, 300, 100, "Ex1"); // Ex1
        drawLine(0, 0,  50, 400, "Ex2"); // Ex2
        drawLine(0, 0, 400, 400, "Ex3"); // Ex3
    }

    public static void drawLine(
        int x1, int y1,
        int x2, int y2,
        String title
    ) {
        BresenhamLine bresenhamLine = new BresenhamLine(x1, y1, x2, y2);
        bresenhamLine.setPreferredSize(new Dimension(600, 600));
        
        JFrame frame = new JFrame(title);
        frame.setSize(800, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(bresenhamLine);
        frame.pack();
        frame.setVisible(true);
    }
    public static void drawLine(int x1, int y1, int x2, int y2) {
        drawLine(x1, y1, x2, y2, "Bresenham Line");
    }
}