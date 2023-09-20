package ch1;

public class SumGauss7 {
    public static void main(String[] args) {
        int n = 11;
        int sum = 0;
        if (n%2==0){
            sum += n/2*(n+1);
        } else if (n%2==1) {
            sum += n*((n+1)/2);
        }
        // 1~10 sum = 55
        // 1~9 sum = 45
        // 1~11 sum = 66
        System.out.println(sum);
        // 1 2 3 4 5 6 7 8 9
    }
}
