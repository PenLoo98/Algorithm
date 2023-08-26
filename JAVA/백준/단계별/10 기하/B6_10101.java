import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6_10101 {
    public static void main(String[] args) throws IOException {
        // 3 각을 입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Angle1 = Integer.parseInt(br.readLine());
        int Angle2 = Integer.parseInt(br.readLine());
        int Angle3 = Integer.parseInt(br.readLine());

        // 비교 결과값 출력
        int sum = Angle1+Angle2+Angle3;
        if(Angle1 == 60 & Angle2 == 60 & Angle3 == 60){
            System.out.println("Equilateral");
        } else if (sum==180 & (Angle1==Angle2 | Angle1==Angle3 | Angle2==Angle3) ) {
            System.out.println("Isosceles");
        } else if (sum==180) {
            System.out.println("Scalene");
        } else{
            System.out.println("Error");
        }
    }
}