import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Lab6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Lab Manual
            showWindow("Bézier 1",
                new int[]{300,600},
                new int[]{600,400},
                new int[]{350,500},
                new int[]{620,350},
                400000
            );

            // Exercises
            showWindow("Bézier 2",
                new int[]{100,100},
                new int[]{450,250},
                new int[]{300,50},
                new int[]{500,100},
                1000
            );
            showWindow("Bézier 3",
                new int[]{200,250},
                new int[]{550,600},
                new int[]{300,350},
                new int[]{500,450},
                1000
            );
        });
    }

    private static void showWindow(String title, int[] p0, int[] p1, int[] p0dash, int[] p1dash, int steps) {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new BezierCurve(p0, p1, p0dash, p1dash, steps));
        f.setSize(600,600);
        f.setVisible(true);
    }
}