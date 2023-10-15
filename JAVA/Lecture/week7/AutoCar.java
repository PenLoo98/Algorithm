package lecture.week7;

public class AutoCar extends obstacle implements OperateCar{
    public void start(){
        System.out.println("자동차가 출발합니다.");
    }

    public void stop(){
        System.out.println("자동차가 정지합니다.");
    }

    @Override
    public void setSpeed(int speed) {
        System.out.println("자동차의 속도를 "+speed+"km/h로 바꿉니다.");
    }

    @Override
    public void turn(int degree) {
        System.out.println("자동차의 방향을 "+degree+"도 만큼 바꿉니다.");
    }

    @Override
    void emerStop(int dist) {
        System.out.println("자동차가 "+dist+"m 앞에서 급정거 했습니다.");
    }

    @Override
    void obs(String whatIsIt) {
        System.out.println("앞에 "+whatIsIt+"이 발견되었습니다.");
    }


}
