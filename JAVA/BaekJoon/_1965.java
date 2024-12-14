import java.util.*;
import java.io.*;

public class _1965 {
    public static void main(String[] args) throws IOException{
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer boxesInput = new StringTokenizer(br.readLine());
        int[] boxes = new int[n];
        for(int i=0;i<n;i++){
            boxes[i] = Integer.parseInt(boxesInput.nextToken());
        }

        // dp[i]에서 인덱스 i일 때 가능한 최대 개수를 저장
        // 1 6 2 5 7 3 5 6
        // 1 2 2 3 4 4 4 5
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(boxes[i] < boxes[j]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }

        // 최대 박스 개수 구하기
        int maxBoxes = 0;
        for(int value: dp){
            maxBoxes = Math.max(maxBoxes, value);
        }

        System.out.println(maxBoxes);
    }
}