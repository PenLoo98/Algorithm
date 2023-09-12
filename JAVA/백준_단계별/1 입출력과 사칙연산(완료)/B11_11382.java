import java.util.Scanner;

public class B11_11382 {
    public static void main(String[] args){
        // 3개의 수를 입력
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        
        // 3개 수의 합을 출력
        System.out.print(A+B+C);
    }
}
