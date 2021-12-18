import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Transformation2D extends JPanel {
    private BufferedImage image;
    private ITransformationStrategy[] strategies;

    Transformation2D(ITransformationStrategy... strategies) {
        image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        this.strategies = strategies;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (ITransformationStrategy strategy: strategies) {
            strategy.paint(g);
        }

        g.drawImage(image, 0, 0, null);
    }
}
