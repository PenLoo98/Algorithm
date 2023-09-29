package ch2;

import java.util.Arrays;

public class ch2_Q2 {
    public static void main(String[] args) {
        int[] list = {2,5,1,3,9,6,7};
        System.out.println(Arrays.toString(list));
        swapElement(list,0,6);
        System.out.println(Arrays.toString(list));
    }
    public static void swapElement(int[] list, int at, int from){
        int temp = list[at];
        list[at] = list[from];
        list[from] = temp;
    }
}
