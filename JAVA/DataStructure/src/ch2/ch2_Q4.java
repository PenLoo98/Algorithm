package ch2;

import java.util.Arrays;

public class ch2_Q4 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {6,7,8,9,10,11};
        copyList(a,b);
        System.out.println("a: "+ Arrays.toString(a));
    }
    static void copyList(int[] a, int[] b){
        if(a.length != b.length){
            System.out.println("a와 b의 배열의 길이가 다릅니다.");
            return;
        }
        for(int i=0;i<b.length;i++){
            a[i] = b[i];
        }
    }
}
