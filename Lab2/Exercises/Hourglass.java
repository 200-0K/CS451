import java.awt.*;
import javax.swing.*;

public class Hourglass {
    public void run() {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    class GraphicsCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            int midY = 150;
            
            int x1 = 50;
            int y1 = 100;
            g.setColor(Color.RED);
            g.drawPolygon(new int[] {x1,x1*2,x1*3}, new int[] {y1,midY,y1}, 3);

            int x2 = x1;
            int y2 = y1 + ((midY - y1) * 2);
            g.drawPolygon(new int[] {x2,x2*2,x2*3}, new int[] {y2,midY,y2}, 3);
        }
    }

    class Frame extends JFrame {
        Frame() {
            initUI();
        }

        void initUI() {
            add(new GraphicsCanvas());
            setTitle("Hourglass");
            setSize(400,400);
        }
    }
}
