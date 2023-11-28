package lecture.week13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBall extends JFrame implements ActionListener{
    static final int WIDTH = 600;
    static final int HEIGHT = 200;
    private static final int PERIOD = 10;

    class MyPanel extends JPanel {
        int xInc = 4, yInc = 4, diameter = 50;
        int xInc2 = 4, yInc2 = 4, diameter2 = 50;

        private int x=0, y=0;
        private int x2=130, y2=130;
        private Color color = Color.RED;
        private Color color2 = Color.BLUE;

        public void paintComponent(Graphics g) {
            // 빨간 공
            super.paintComponent(g);
            if (x < 0 || x > (BouncingBall.WIDTH - diameter)) {
                xInc = -xInc;
            }
            if (y < 0 || y > (BouncingBall.HEIGHT - diameter)) {
                yInc = -yInc;
            }
            x += xInc;
            y += yInc;
            g.setColor(this.color);
            g.fillOval(x, y, diameter, diameter);

            // 파란 공
            if (x2 < 0 || x2 > (BouncingBall.WIDTH - diameter2)) {
                xInc2 = -xInc2;
            }
            if (y2 < 0 || y2 > (BouncingBall.HEIGHT - diameter2)) {
                yInc2 = -yInc2;
            }
            x2 += xInc2;
            y2 += yInc2;
            g.setColor(this.color2);
            g.fillOval(x2, y2, diameter2, diameter2);

            // 공들이 부딪혔을 때
            if (Math.sqrt(Math.pow(x-x2, 2) + Math.pow(y-y2, 2)) < diameter/2 + diameter2/2){
                xInc = -xInc;
                yInc = -yInc;
                xInc2 = -xInc2;
                yInc2 = -yInc2;
            }
        }
    }

    public BouncingBall() {
        MyPanel panel = new MyPanel();

        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(panel);

        pack();
        setTitle("Bouncing Ball");
        Timer timer = new Timer(PERIOD, this);
        timer.start();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        repaint();
    }

    public static void main(String[] args){
        BouncingBall balls = new BouncingBall();
    }
}