package ch1;

public class ch1_Q16 {
    public static void main(String[] args) {
        npira(10);
    }

    static void npira(int n){
        for(int i=1;i<=n;i++){
            System.out.print(" ".repeat(n-i));
            System.out.print(Integer.toString(i%10).repeat((i-1)*2+1));
            System.out.println(" ".repeat(n-i));
        }
    }
}
