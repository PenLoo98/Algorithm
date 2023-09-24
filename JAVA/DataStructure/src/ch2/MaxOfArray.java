package ch2;

import java.util.Scanner;

public class MaxOfArray {
    static int maxOf(int[] a) {
        int max = a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("키의 최댓값을 구합니다");
        System.out.print("사람 수: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            System.out.printf("height[%d]: ",i);
            a[i] = sc.nextInt();
        }
        System.out.printf("최댓값은 %d입니다.", maxOf(a));
    }
}
