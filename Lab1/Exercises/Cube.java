import java.awt.*;
import javax.swing.*;

public class Cube {
    public void run() {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    class GraphicsCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            int width = 100;
            int height = 120;

            int r1x = 120;
            int r1y = 100;
            g.setColor(Color.BLUE);
            g.draw3DRect(r1x, r1y, width, height, false);

            int r2x = r1x + (r1x/3);
            int r2y = r1y + (r1y/3);
            g.setColor(Color.RED);
            g.draw3DRect(r2x, r2y, width, height, false);
            
            g.setColor(Color.BLACK);
            g.drawLine(r1x, r1y, r2x, r2y);
            g.drawLine(r1x, r1y+height, r2x, r2y+height);
            g.drawLine(r1x+width, r1y, r2x+width, r2y);
            g.drawLine(r1x+width, r1y+height, r2x+width, r2y+height);
        }
    }

    class Frame extends JFrame {
        Frame() {
            initUI();
        }

        void initUI() {
            add(new GraphicsCanvas());
            setTitle("Cube");
            setSize(400, 400);
        }
    }
}
