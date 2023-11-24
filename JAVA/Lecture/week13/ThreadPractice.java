package lecture.week13;

class PrintNumber extends Thread {
    public void run() {
        for (int i = 0; i < 24; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PrintChar implements Runnable{
    public void run() {
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadPractice {
    public static void main(String[] args) {
//        PrintNumber pn = new PrintNumber();
//        Thread t1 = new Thread(pn);
        Thread t1 = new PrintNumber();
        t1.start();

//        PrintChar pc = new PrintChar();
//        Thread t2 = new Thread(pc);
        Thread t2 = new Thread(new PrintChar());
        t2.start();

    }
}
