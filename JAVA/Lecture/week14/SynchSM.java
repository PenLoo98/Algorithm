package lecture.week14;

import static lecture.week14.SynchSM.Producer.sum;

// synch를 걸어줘야하만 55가 제대로 나온다.
//만약 synch를 걸지 않으면 55가 나오지 않을 수 있음.

public class SynchSM {
    private int synchSMSize = 3;
    int stockSM = 0;
    static int sum = 0;
    static int addNum = 1;

    public synchronized void producer(String producerName, int producerNo){
        while (stockSM == synchSMSize){
            try{
                wait();
            }
            catch (InterruptedException e) {

            }
            stockSM++;
        }
        System.out.println(producerName+ "("+producerNo+")"+" stockSM=" + stockSM);
        notifyAll();
    }

    public synchronized void consumer(String consumerName, int consumerNo){
        while (stockSM == 0){
            try {
                wait();
            }
            catch (InterruptedException e){

            }
            stockSM--;
        }
        System.out.println(consumerName+ "("+consumerNo+")"+" stockSM=" + stockSM);
        notifyAll();
    }

    public static class Producer implements Runnable{

        public static int sum=0;
        private SynchSM synchsm;
        String producerName;

        public Producer(SynchSM synchsm, String producerName){
            this.synchsm = synchsm;
            this.producerName = producerName;
        }
        public void run(){
            for(int i=1;i<=5;i++){
                synchsm.producer(producerName, i);
                synchronized (synchsm) {
                    synchsm.sum += addNum;
                    addNum++;
                }
                try{
                    Thread.sleep((int) (Math.random()*1));
                }
                catch (InterruptedException e){}
            }
        }
    }

    public class Consumer implements Runnable{
        private SynchSM synchsm;
        String consumerName;
        public Consumer(SynchSM synchsm, String consumerName){
            this.synchsm = synchsm;
            this.consumerName = consumerName;
        }
        public void run(){
            for(int i=1;i<=3;i++){
                synchsm.consumer(consumerName, i);
                try{
                    Thread.sleep((int) (Math.random()*10));
                }
                catch (InterruptedException e){}
            }
        }
    }
}

class ProducerConsumerTest {
    public static void main(String[] args) {
        SynchSM synchsm = new SynchSM();
        Thread p1 = new Thread(new SynchSM.Producer(synchsm, "p1"));
        Thread p2 = new Thread(new SynchSM.Producer(synchsm, "p2"));
        p1.start();
        p2.start();

        try {
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sum= "+ synchsm.sum);
    }
}