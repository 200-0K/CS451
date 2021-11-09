import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Lab7 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            showWindow("Translate",
                new TranslateStrategy()
            );
            showWindow("Rotate",
                new RotateStrategy()
            );
            showWindow("Scale",
                new ScaleStrategy()
            );
            showWindow("Shear",
                new ShearStrategy()
            );
        });
    }

    private static void showWindow(String title, ITransformationStrategy... strategies) {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Transformation2D(strategies));
        f.setSize(400,400);
        f.setVisible(true);
    }
}