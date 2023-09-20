package ch1;

import java.util.Scanner;

public class ch1_Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a값:");
        int a = sc.nextInt();

        int b;
        do{
            System.out.print("b값:");
            b = sc.nextInt();
            if(b<=a){
                System.out.println("a보다 큰 값을 입력하세요!");
            }
        } while (b<=a);
        System.out.print("b값:");
        System.out.printf("b-a는 %d입니다.", b-a);
    }
}
