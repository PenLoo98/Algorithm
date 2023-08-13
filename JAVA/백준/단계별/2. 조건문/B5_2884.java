import java.time.LocalTime;
import java.util.Scanner;

public class B5_2884 {
    public static void main(String[] args){
        // 1. 시, 분 입력
        Scanner sc = new Scanner(System.in);
        short H = sc.nextShort();
        short M = sc.nextShort();

        // 2. 45분을 빠진 시간 구하기
        LocalTime time = LocalTime.of(H,M).minusMinutes(45);

        // 3. 계산된 시간 출력
        System.out.println(time.getHour()+" "+time.getMinute());
    }
}