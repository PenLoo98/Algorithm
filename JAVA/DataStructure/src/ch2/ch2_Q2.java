package ch2;

import java.util.Arrays;

public class ch2_Q2 {
    public static void main(String[] args) {
        int[] list = {2,5,1,3,9,6,7};
        System.out.println(Arrays.toString(list));
        swapElement(list,0,6);
        swapElement(list,1,5);
        swapElement(list,2,4);
        System.out.println("역순 정렬을 마쳤습니다.");

    }
    public static void swapElement(int[] list, int at, int from){
        int temp = list[at];
        list[at] = list[from];
        list[from] = temp;
        System.out.printf("a[%d]와 a[%d]를 교환합니다.\n",at,from);
        System.out.println(Arrays.toString(list));
    }
}
