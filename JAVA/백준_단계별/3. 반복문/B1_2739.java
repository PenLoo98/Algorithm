import java.util.Scanner;

public class B1_2739 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        short n = sc.nextShort();

        for(short i=1;i<10;i++){
            String out = String.format("%d * %d = %d", n, i, n*i);
            System.out.println(out);
        }
    }
}