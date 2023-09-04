import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4_24265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        System.out.println(n*(n-4));
        System.out.println(2);
    }
}