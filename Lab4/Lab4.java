import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Lab4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            showMidPointCircle(50 , "R1");
            showMidPointCircle(100, "R2");
            showMidPointCircle(300, "R3");
        });
    }

    private static void showMidPointCircle(int r, String title) {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MidPoint(r));
        f.setSize(600,600);
        f.setVisible(true);
    }
}