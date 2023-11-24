package lecture.week13;

import javax.swing.*;

// TODO: 벽에 닿은 그림은 멈추도록하기.
public class CarGame extends JFrame {
    class MyThread extends Thread{
        private JLabel label;
        private JTextPane textPane;
        private int x, y;
        private String fname;

        public MyThread(String fname, int x, int y){
            this.x = x;
            this.y = y;
            this.fname = fname;
            label = new JLabel();
            label.setIcon(new ImageIcon(fname));
            label.setBounds(x, y, 256, 256);
            add(label);

            // TODO: 파일 이름 UI 좌측에 표시
            JLabel text = new JLabel(fname);
            text.setBounds(x-100, y, 100, 100);
            add(text);
        }

        public void run(){
            for (int i=0; i<200; i++){
                x += 10 * Math.random();
                // TODO: 벽에 닿은 그림은 멈추도록하기.
                if(x < 384){
                    // TODO: x좌표 변화 로그 찍기
                    System.out.println(this.fname+": "+x);

                    label.setBounds(x, y, 128, 128);
                    repaint(); // 화면 갱신하고 다시 그리도록 함
                }
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public CarGame(){
        setTitle("Car Race");
        setSize(512, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        (new MyThread("car1.png", 100, 0)).start();
        (new MyThread("car2.png", 100, 128)).start();
        (new MyThread("car3.png", 100, 256)).start();
        setVisible(true);
    }

    public static void main(String[] args) {
        CarGame carGame = new CarGame();
    }
}
