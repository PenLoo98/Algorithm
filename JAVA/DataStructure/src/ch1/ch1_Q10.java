package ch1;

import java.util.Scanner;

public class ch1_Q10 {
    public static void main(String[] args) {
        // 양의 정수 입력 -> int타입
        Scanner sc = new Scanner(System.in);
        System.out.print("확인할 정수타입 자릿수를 입력하세요");
        int input = sc.nextInt(); //120

        // 입력한 수 자릿수 계산
        // do-while 사용해서 10씩 나눌까?
        int length = 0;
        do{
            input /= 10;
            length++;
        } while(input!=0);

        // 자릿수 출력
        System.out.printf("그 수는 %d자리입니다.", length);
    }
}
