import java.util.Scanner;
public class B3_1001 {
    public static void main(String[] args){
        // 두 수 A,B를 입력
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        // A-B 출력
        System.out.print(A-B);
        sc.close();
    }
}

