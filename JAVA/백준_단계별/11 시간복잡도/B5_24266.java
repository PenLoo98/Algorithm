import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B5_24266 {
    public static void main(String[] args) throws Exception{
        // 수행횟수 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        // 수행횟수에 따른 결과 출력
        System.out.println(n*n*n);
        System.out.println(3);
    }
}