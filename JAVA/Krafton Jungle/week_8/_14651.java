import java.io.*;
import java.math.BigInteger;

public class _14651 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(0);
            return;
        }
        // 점화식: f(n) = 2*3^(n-2)
        BigInteger numerator = new BigInteger("2");
        for (int i = 0; i < n-2; i++) {
            numerator = numerator.multiply(new BigInteger("3"));
        }
        BigInteger bi = new BigInteger("1000000009");
        System.out.println(numerator.mod(bi));
    }
}