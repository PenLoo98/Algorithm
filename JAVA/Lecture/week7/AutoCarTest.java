package lecture.week7;

public class AutoCarTest {
    public static void main(String[] args) {
        AutoCar obj = new AutoCar();
        obj.start();
        obj.setSpeed(30);
        obj.turn(15);
        obj.stop();
        obj.emerStop(3);
        obj.obs("bicycle");
    }
}
