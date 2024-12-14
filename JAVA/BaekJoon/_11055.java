import java.util.*;
import java.io.*;

public class _11055 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 배열을 arr에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. DP 초기화 및 점화식
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i]; // 초기값은 자기 자신
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]); // 최대 합 갱신
        }

        // 3. 출력
        System.out.println(maxSum);
    }
}