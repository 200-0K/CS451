import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Lab8 {
    public static void main(String[] args) {
        int[] screenRes = {600, 600};
        int lines[][] = {
            {700, 10, 800, 680},
            {400, 500, 700, 100},
            {200, 100, 3, 5},
            {200, 100, 1000, 500}
        };
        SwingUtilities.invokeLater(() -> {
            showWindow("Line Clipping 1",
                new LineClipper(screenRes, lines)
            );
        });
    }

    private static void showWindow(String title, Component c) {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(c);
        f.setSize(400,400);
        f.setVisible(true);
    }
}