import java.awt.*;
import javax.swing.*;

public class LabA {
    public void run() {
        Lab obj_graphics = new Lab();
        obj_graphics.setVisible(true);
    }

    class GraphicsCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);
            g.drawRect(200, 200, 200, 200);
            g.drawRect(180, 180, 240, 240);
            g.drawRect(150, 150, 300, 300);
        }
    
        void print(Graphics g, int x, int y, String printString) {
            g.drawString(printString, x, y);
        }
    }
    
    class Lab extends JFrame {
        Lab() {
            initUI();
        }
    
        void initUI() {
            add(new GraphicsCanvas());
            setTitle(" Lab 1 ");
            setSize(700, 700);
        }
    }
}