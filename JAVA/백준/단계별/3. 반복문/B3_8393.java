import java.util.Scanner;

public class B3_8393 {
    public static void main(String[] args) {
        // 1. n 입력
        Scanner sc = new Scanner(System.in);
        short n = sc.nextShort();

        // 2. 결과 출력
        System.out.println(n*(n+1)/2);
    }
}