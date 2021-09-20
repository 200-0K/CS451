import java.awt.*;
import javax.swing.*;

public class Arc {
    public void run() {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    class GraphicsCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.BLUE);
            int x1 = 250;
            int y1 = 100;
            int x2 = y1;
            int y2 = x1;
            g.drawLine(x1, y1, x2, y2);

            int d = (int)Math.round(Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y2-y1, 2)));
            final int r = d/2;
            int startAngle = 45;
            int arcAngle = 180;
            g.drawArc(
                (int)Math.round( (x1-r) - (r * Math.cos(startAngle * Math.PI/180)) ), // if angle = 0 then this = x1-d
                (int)Math.round( (y1-r) + (r * Math.sin(startAngle * Math.PI/180)) ), // if angle = 0 then this = y1-r
                d, 
                d, 
                startAngle, 
                arcAngle
            );
        }
    }

    class Frame extends JFrame {
        Frame() {
            initUI();
        }

        void initUI() {
            add(new GraphicsCanvas());
            setTitle("Arc");
            setSize(400,400);
        }
    }
}
