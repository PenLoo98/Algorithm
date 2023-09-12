import java.util.Scanner;

public class B5_25314 {
    public static void main(String[] args) {
        // 1. 정수 N 입력
        Scanner sc = new Scanner(System.in);
        short N = sc.nextShort();

        // 2. long 갯수 계산
        short count = (short) (N/4);


        // 3. 결과값 출력
        for(short i=0;i<count;i++){
            System.out.print("long ");
        }
        System.out.println("int");
    }
}