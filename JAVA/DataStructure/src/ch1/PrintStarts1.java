package ch1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintStarts1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,w;

        System.out.println("*을 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");

        // 양수인 n,w 입력
        do {
            n = sc.nextInt();
        } while(n<=0);
        do {
            w = sc.nextInt();
        } while(w<=0);

        // 방법 1: *출력
//        int loop = n/w;
//        int remain = n%w;
//
//        // *를 w번 반복한 문자열 생성
//        StringBuilder sbLoop = new StringBuilder();
//        for(int i=0;i<w;i++){
//            sbLoop.append("*");
//        }
//        sbLoop.append("\n");
//
//        for(int j=0;j<loop;j++){
//            System.out.print(sbLoop);
//        }
//
//        StringBuilder sbRemain = new StringBuilder();
//        for(int k=0;k<remain;k++){
//            sbRemain.append("*");
//        }
//        sbRemain.append("\n");
//
//        System.out.print(sbRemain);

         //방법 2: *출력
        for(int i=0;i<n/w;i++){
            System.out.print("*".repeat(w)+"\n");
        }
        if(n%w!=0){
            System.out.print("*".repeat(n%w));
        }
    }
}

