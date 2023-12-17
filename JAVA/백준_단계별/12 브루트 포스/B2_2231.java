import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B2_2231 {
    public static void main(String[] args) throws IOException {
        // N을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1부터 N까지 분해합을 구한다.
        List<Long> constructor = new ArrayList<>();
        for (long i = 1; i <= N; i++) {
            long sum = i;
            long temp = i;
            while (temp != 0){
                sum += temp%10;
                temp /= 10;
            }
            if (sum == N){
                constructor.add(i);
            }
        }

        System.out.println(constructor.isEmpty() ? 0 : constructor.get(0));
    }
}
