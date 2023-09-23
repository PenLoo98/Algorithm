package ch1;

public class ch1_Q14 {
    public static void main(String[] args) {
//        triangleLB(5);
//        triangleLU(5);
//        triangleRU(5);
        triangleRB(5);
    }

    static void triangleLB(int n){
        for(int i=1;i<=n;i++){
            System.out.println("*".repeat(i));
        }
    }
    static void triangleLU(int n){
        for(int i=n;i>=0;i--){
            System.out.println("*".repeat(i));
        }
    }
    static void triangleRU(int n){
        for(int i=n;i>=0;i--){
            System.out.print(" ".repeat(n-i));
            System.out.println("*".repeat(i));
        }
    }
    static void triangleRB(int n){
        for(int i=n;i>=0;i--){
            System.out.print("*".repeat(i));
            System.out.println(" ".repeat(n-i));
        }
    }
}
