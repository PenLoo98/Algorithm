package lecture.week9;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private JButton b1,b2,b3;

    public MyFrame(){
        setTitle("Absolute Position Test");
        setSize(300, 150);
        setLayout(new BorderLayout());

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        b1 = new JButton("Button #1");
        b2 = new JButton("Button #2");
        b3 = new JButton("Button #3");

        cardPanel.add(b1);
        cardPanel.add(b2);
        cardPanel.add(b3);

        b1.addActionListener(e -> cardLayout.next(cardPanel));
        b2.addActionListener(e -> cardLayout.next(cardPanel));
        b3.addActionListener(e -> cardLayout.next(cardPanel));

        add(cardPanel, BorderLayout.NORTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}


