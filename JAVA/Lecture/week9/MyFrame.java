package lecture.week9;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private JButton b1,b2,b3;

    public MyFrame(){
        setTitle("Absolute Position Test");
        setSize(300, 150);

        JPanel cardPanel = new JPanel();
        Container cPane = getContentPane();

        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);


        b1 = new JButton("Button #1");
        add(b1, "North");
        b1.setSize(90,20);

        b2 = new JButton("Button #2");
        add(b2, "North");
        b1.setSize(90,20);

        b3 = new JButton("Button #3");
        add(b3, "North");
        b1.setSize(90,20);

        b1.addActionListener(e -> cardLayout.next(cPane));
        b2.addActionListener(e -> cardLayout.next(cPane));
        b3.addActionListener(e -> cardLayout.next(cPane));

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}


