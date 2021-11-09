import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public interface ITransformationStrategy {
    void paint(Graphics g);
}

class TranslateStrategy implements ITransformationStrategy {
    @Override
    public void paint(Graphics g) {
        g.fillRect(20, 20, 80, 50);
        g.translate(150, 50);
        g.fillRect(20, 20, 80, 50);
        g.dispose();
    }
}

class RotateStrategy implements ITransformationStrategy {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.fillRect(20, 20, 80, 50);
        g2d.translate(180, -50);
        g2d.rotate(Math.PI/4);
        g2d.fillRect(80, 80, 80, 50);
        g2d.dispose();
    }
}

class ScaleStrategy implements ITransformationStrategy {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        AffineTransform tx;

        g2d.fillRect(20, 20, 80, 50);
        
        tx = new AffineTransform();
        tx.translate(110, 22);
        tx.scale(.5, .5);
        g2d.setTransform(tx);
        g2d.fillRect(0, 0, 80, 50);

        tx = new AffineTransform();
        tx.translate(170, 20);
        tx.scale(1.5, 1.5);
        g2d.setTransform(tx);
        g2d.fillRect(0, 0, 80, 50);

        g2d.dispose();
    }
}

class ShearStrategy implements ITransformationStrategy {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        AffineTransform tx;

        tx = new AffineTransform();
        tx.translate(50, 90);
        g2d.setTransform(tx);
        g2d.drawRect(0, 0, 160, 50);

        tx = new AffineTransform();
        tx.translate(50, 90);
        tx.shear(0, 1);
        g2d.setTransform(tx);
        g2d.drawRect(0, 0, 80, 50);

        tx = new AffineTransform();
        tx.translate(130, 10);
        tx.shear(0, 1);
        g2d.setTransform(tx);
        g2d.drawRect(0, 0, 80, 50);

        g2d.dispose();
    }
}