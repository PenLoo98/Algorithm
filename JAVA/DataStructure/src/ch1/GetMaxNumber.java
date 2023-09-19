package ch1;

import java.util.Scanner;

public class GetMaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.println("a의 값: "); int a = sc.nextInt();
        System.out.println("b의 값: "); int b = sc.nextInt();
        System.out.println("c의 값: "); int c = sc.nextInt();
        System.out.println("d의 값: "); int d = sc.nextInt();

        int max3 = max3(a,b,c);
        int max4 = max4(a,b,c,d);
        int min3 = min3(a,b,c);
        int min4 = min4(a,b,c,d);

        System.out.println("a,b,c의 최대값은 "+max3+" 입니다.");
        System.out.println("a,b,c,d의 최대값은 "+max4+" 입니다.");
        System.out.println("a,b,c의 최대값은 "+min3+" 입니다.");
        System.out.println("a,b,c,d의 최대값은 "+min4+" 입니다.");

    }
    static int max3(int a, int b, int c){
        int max = a;
        if(b>max) max=b;
        if(c>max) max=c;
        return max;
    }
    static int max4(int a, int b, int c,int d){
        int max = a;
        if(b>max) max=b;
        if(c>max) max=c;
        if(d>max) max=d;
        return max;
    }
    static int min3(int a, int b, int c){
        int min = a;
        if(b<min) min=b;
        if(c<min) min=c;
        return min;
    }
    static int min4(int a, int b, int c,int d){
        int min = a;
        if(b<min) min=b;
        if(c<min) min=c;
        if(d<min) min=d;
        return min;
    }
}
