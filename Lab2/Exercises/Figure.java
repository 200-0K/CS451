import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class Figure {
    public void run() {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    class GraphicsCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            BufferedImage image;
            try {
                image = ImageIO.read(this.getClass().getResource("img-1.png"));
                int width = 500;
                int height = 500;
                g.drawImage(image, 0, 0, width, height, this);

                g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                g.setColor(Color.decode("#ee701f"));
                g.drawString("Coffee?", (int)Math.round(width/2.5), height+50);
            } catch (IOException e) {e.printStackTrace();}
        }
    }

    class Frame extends JFrame {
        Frame() {
            initUI();
        }

        void initUI() {
            add(new GraphicsCanvas());
            setTitle("Figure");
            setSize(700,700);
        }
    }
}
