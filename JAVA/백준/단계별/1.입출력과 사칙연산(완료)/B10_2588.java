import java.util.Scanner;

public class B10_2588 {
    public static void main(String[] args){
        // 두 수를 입력 -> int
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 2번째 수를 각각 일,십,백의 자리 숫자를 구함 -> /,%연산자
        int B100 = B/100;
        int B10 = (B%100)/10;
        int B1 = B%10;

        // 1번째 수와 2번째 수 일,십,백 각각을 곱한 값을 출력
        System.out.println(A*B1);
        System.out.println(A*B10);
        System.out.println(A*B100);

        // 두 수의 곱을 출력
        System.out.println(A*B);
    }
}
