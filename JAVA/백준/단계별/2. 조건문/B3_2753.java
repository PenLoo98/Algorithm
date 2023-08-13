import java.util.Scanner;

public class B3_2753{
    public static void main(String[] args){
        // 1. 년도 입력
        Scanner sc = new Scanner(System.in);
        short year = sc.nextShort();

        // 2. 윤년인지 확인 -> 결과에 맞춰 출력
        if( ((year%4==0) & (year%100!=0)) | (year%400==0) ){
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}