import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Lab5 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Lab Manual
            showWindow("Hermite 1",
                new int[]{200,300},
                new int[]{700,400},
                new int[]{300,350},
                new int[]{750,100},
                400
            );

            // Exercises
            showWindow("Hermite 2",
                new int[]{100,200},
                new int[]{300,350},
                new int[]{50,150},
                new int[]{200,300},
                200
            );
            showWindow("Hermite 3",
                new int[]{100,200},
                new int[]{150,200},
                new int[]{200,300},
                new int[]{300,450},
                200
            );
        });
    }

    private static void showWindow(String title, int[] p0, int[] p1, int[] p0dash, int[] p1dash, int steps) {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new HermiteCurve(p0, p1, p0dash, p1dash, steps));
        f.setSize(600,600);
        f.setVisible(true);
    }
}