package ch1;

import java.util.Scanner;

public class TwoDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // 2자리 숫자인지 확인
        do {
            n=sc.nextInt();
        } while (n<10 || n>99);
    }
}
