import java.util.Scanner;

public class B7_2480 {
    public static void main(String[] args){
        // 1. 주사위 눈 입력
        Scanner sc = new Scanner(System.in);
        short a = sc.nextShort();
        short b = sc.nextShort();
        short c = sc.nextShort();

        // 2. 상금 계산 -> 출력

        // 2-1. 같은 눈 3개가 나온 경우
        if(a==b & b==c & c==a){
            System.out.println(10000+a*1000);
        }

        // 2-2. 같은 눈 2개가 나온 경우
        else if( a==b | b==c | c==a){
            if(a==b){
                System.out.println(1000+a*100);
            }
            if(b==c){
                System.out.println(1000+b*100);
            }
            if(c==a){
                System.out.println(1000+c*100);
            }
        }

        // 2-3. 모든 다른 눈이 나온 경우
        else {
            // a가 제일 큰 경우
            if(a>b & a>c){
                System.out.println(a*100);
            }
            // b가 제일 큰 경우
            else if(b>a & b>c){
                System.out.println(b*100);
            }
            // c가 제일 큰 경우
            else{
                System.out.println(c*100);
            }
        }
    }
}