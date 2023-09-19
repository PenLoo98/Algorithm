package ch1;

import java.util.Scanner;

public class GetMedian {
    static int med3(int a, int b, int c){
        int median=0;
        // a가 최대값인 경우
        if(a>=b){
            if(b>=c){
                median = b;
            }
            else{// b<c
                if(a>=c){
                    median = c;
                }
                else {// b<=a<c
                    median = a;
                }
            }
        }
        else{// a<b
            if(a>=c){
                median=a;
            }
            else {//a<b && a<c
                if(b>=c){
                    median=c;
                }
                else{
                    median=b;
                }
            }
        }
        // a가 중앙값인 경우
        // a가 최소값인 경우

        return median;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("세 정수의 중앙값을 구합니다.");
        System.out.println("a의 값: "); int a = sc.nextInt();
        System.out.println("b의 값: "); int b = sc.nextInt();
        System.out.println("c의 값: "); int c = sc.nextInt();

        System.out.println("중앙값 "+med3(a,b,c)+" 입니다.");
    }
}
