package ch1;

public class Sumof_8 {
    public static void main(String[] args) {
        System.out.println(sumof(6,4));
    }

    static int sumof(int a, int b){
        int sum = 0;
        if(a>b){
            for(int i=b;i<=a;i++){
                sum += i;
            }
            return sum;
        }
        else{
            for(int i=a;i<=b;i++){
                sum += i;
            }
            return sum;
        }
    }
}
