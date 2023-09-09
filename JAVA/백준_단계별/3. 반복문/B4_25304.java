import java.util.Scanner;

public class B4_25304 {
    public static void main(String[] args) {
        // 1. 변수 입력
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        short N = sc.nextShort();
        int result = 0;


        // 2. 값 계산
        for(short i=0; i<N; i++){
            int a = sc.nextInt();
            short b = sc.nextShort();
            result += a*b;
        }

        // 3. 결과 출력
        if(X == result){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}