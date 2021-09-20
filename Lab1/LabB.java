import java.awt.*;
import javax.swing.*;

public class LabB {
    public void run() {
        Lab lab = new Lab();
        lab.setVisible(true);
    }

    class GraphicsCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(200, 240, 150, 200);
            g.drawRect(120, 150, 150, 200);
            g.drawLine(120, 150, 200, 240);
            g.drawLine(270, 150, 350, 240);
            g.drawLine(270, 350, 350, 440);
            g.drawLine(120, 350, 200, 440);
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
            setTitle(" Lab 2 ");
            setSize(500, 500);
        }
    }
}

