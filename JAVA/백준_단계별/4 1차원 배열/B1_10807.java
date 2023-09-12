import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력받기
        short N = Short.parseShort(br.readLine());
        String[] nums = br.readLine().split(" ");
        short v = Short.parseShort(br.readLine());
        // 2. 계산
        short count = 0;
        for (String num : nums) {
            if(v==Short.parseShort(num)){
                count++;
            }
        }
        // 3. 결과값 출력
        System.out.println(count);
    }
}