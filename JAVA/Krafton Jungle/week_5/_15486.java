import java.io.*;
import java.util.*;

public class _15486 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] schedule = new int[n+1][2];
        // dp[i] = i번째 날까지의 최대 수익
        int[] dp = new int[n+2];
        for(int i=1;i<n+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        // 스케줄링 
        for(int i=1;i<n+1;i++){
            dp[i] = Math.max(dp[i], i==1 ? 0 : dp[i-1]);
            if(i+schedule[i][0] < n+2){
                dp[i+schedule[i][0]] = Math.max(dp[i+schedule[i][0]], dp[i]+schedule[i][1]);
            }
        }
        // 마지막날에 일을 하는 경우와 안하는 경우 중 최대값
        System.out.println(Math.max(dp[n+1], dp[n]));
    }
}