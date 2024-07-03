import java.io.*;
public class _17212 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] coins = new int[]{1,2,5,7};

        // 최대값으로 초기화
        for(int i=1; i<=n; i++){
            dp[i] = 100000;
        }

        // 최소 개수를 구하기
        for(int i=0;i<4;i++){
            for(int j=coins[i];j<=n;j++){
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }

        // 결과 출력 
        System.out.println(dp[n]);
    }
}