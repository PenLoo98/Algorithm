package ch1;

import java.util.Scanner;

public class ch1_Q13 {
    public static void main(String[] args) {
        System.out.println("정사각형을 출력합니다.");
        System.out.print("변의 길이:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("*");
        }

        for(int j=0;j<n;j++){
            System.out.println(sb);
        }
    }
}
