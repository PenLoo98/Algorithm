package ch2;

import java.util.Arrays;

public class ch2_Q5 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {5,6,7,8,9};
        reverseCopy(a,b);
        System.out.println(Arrays.toString(a));
    }
    static void reverseCopy(int[] a, int[] b){
        if(a.length != b.length){
            System.out.println("a와 b의 배열이 다릅니다.");
            return ;
        }
        for(int i=0;i<a.length;i++){
            a[i] = b[a.length-i-1];
        }
    }
}
