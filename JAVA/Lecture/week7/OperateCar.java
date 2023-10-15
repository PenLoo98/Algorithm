package lecture.week7;

public interface OperateCar extends factory{
    void start();
    void stop();
    void setSpeed(int speed);
    void turn(int degree);
}
