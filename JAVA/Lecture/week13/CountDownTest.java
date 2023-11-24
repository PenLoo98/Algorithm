package lecture.week13;

import javax.swing.*;
import java.awt.*;

public class CountDownTest extends JFrame{
    private JLabel label;

    class Counter extends Thread {
        public void run() {
            for (int i=0; i<=10; i++){
                try{
                    Thread.sleep(1000);
                    label.setText(i+"");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public CountDownTest(){
        setTitle("카운트 다운");
        setSize(400,200);
        label = new JLabel("0");
        label.setFont(new Font("Serif", Font.BOLD, 100));
        add(label);
        setVisible(true);

        Thread counter = new Counter();
        counter.start();
    }

    public static void main(String[] args) {
        CountDownTest countDownTest = new CountDownTest();
    }
}
