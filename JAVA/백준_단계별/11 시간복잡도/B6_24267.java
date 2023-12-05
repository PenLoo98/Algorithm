import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B6_24267 {
    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        // 출력
        System.out.println((n*(n-1)*(n-2)/6));
        System.out.println(3);
    }
}