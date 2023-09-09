import java.time.LocalTime;
import java.util.Scanner;

public class B6_2525 {
    public static void main(String[] args){
        // 1. 현재시간과 요리시간 입력
        Scanner sc = new Scanner(System.in);
        short hour = sc.nextShort();
        short minute = sc.nextShort();
        short cookMin = sc.nextShort();

        // 2. 시간 객체 생성
        LocalTime finish = LocalTime.of(hour,minute).plusMinutes(cookMin);

        // 3. 계산된 시간 출력
        System.out.println(finish.getHour()+" "+finish.getMinute());
    }
}