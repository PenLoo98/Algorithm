import java.util.Scanner;

public class B4_14681 {
    public static void main(String[] args){
        // 1. 두 정수 입력
        Scanner sc = new Scanner(System.in);
        Short x = sc.nextShort();
        Short y = sc.nextShort();

        // 2. 사분면 판별 -> 결과 출력
        if(x>=0 & y>=0){
            System.out.println(1);
        }
        if ((x<=0 & y>=0)) {
            System.out.println(2);
        }
        if ((x<=0 & y<=0)) {
            System.out.println(3);
        }
        if ((x>=0 & y<=0)) {
            System.out.println(4);
        }
    }
}