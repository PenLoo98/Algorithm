package lecture;

import java.util.Scanner;

public class BitOperator {
    public static void main(String[] args) {
        // 3번째 비트가 1이면 문이 열림 = true

        // 3번째가 1인지 확인하기 위해 and 연산자로 확인함

        byte status = 0b01101110;
        System.out.println("문열림 상태=" + ((status & 0b00000100)!=0));
    }
}
