import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class _11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1){
            System.out.println(10);
            return;
        }

        BigInteger sumValue = new BigInteger("0");

        // dp=[10,9,8,7,6,5,4,3,2,1]로 초기화
        int[] dp = new int[10];
        for(int j=0;j<10;j++){
            dp[j] = 10-j;
        }

        // n-2번 반복
        for(int i=0;i<n-2;i++){
            // 9부터 0까지 역순으로 더해주기
            for(int j=8;j>=0;j--){
                dp[j] = dp[j] + dp[j+1];
                dp[j] %= 10007;
            }   
        }

        // 오르막수 개수를 저장하는 배열
        for(int j=0;j<10;j++){
            sumValue = sumValue.add(BigInteger.valueOf(dp[j]));
        }
        
        sumValue = sumValue.remainder(new BigInteger("10007"));

        System.out.println(sumValue);
    }
}