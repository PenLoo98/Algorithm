package ch2;

public class ch2_Q3 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(sumOf(array));
    }

    static int sumOf(int[] a){
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        return sum;
    }
}
