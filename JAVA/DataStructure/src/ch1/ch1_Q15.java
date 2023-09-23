package ch1;

public class ch1_Q15 {
    public static void main(String[] args) {
        spira(4);
    }

    static void spira(int n){
        for(int i=1;i<=n;i++){
            System.out.print(" ".repeat(n-i));
            System.out.print("*".repeat((i-1)*2+1));
            System.out.println(" ".repeat(n-i));
        }
    }
}
