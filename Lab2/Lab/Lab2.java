import java.awt.*;
import javax.swing.*;

public class Lab2 {
    public static void main(String[] args) {
        // Custom Line
        System.out.print("Enter x1 y1 x2 y2, respectively (from zero to 600): ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        drawLine(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        // Ex1
        drawLine(100, 70, 250, 200, "Ex1");
        // Ex2
        drawLine(100, 200, 200, 450, "Ex2");
    }

    static void drawLine(int x1, int y1, int x2, int y2) {drawLine(x1, y1, x2, y2, "DDA Line");}
    static void drawLine(int x1, int y1, int x2, int y2, String frameTitle) {
        DDA line = new DDA(x1, y1, x2, y2);
        line.setPreferredSize(new Dimension(600, 600));

        JFrame frame = new JFrame(frameTitle);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(line);
        frame.pack();
        frame.setVisible(true);
    }
}