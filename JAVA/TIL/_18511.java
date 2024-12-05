import java.util.*;
import java.io.*;

public class _18511 {
    static int maxValue=0;
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        // 최대값 구하기
        dfs(N, arr, 0);

        // 최대값 출력
        System.out.println(maxValue);
    }
    public static void dfs(int N, int[] arr, int num){
        // 종료 조건
        if(N < num){
            return;
        }
        // 갱신 조건 
        if(maxValue < num){
            maxValue = num;
        }
        // 탐색 조건 
        for(int i=arr.length-1; i>=0; i--){
            dfs(N, arr, num*10+arr[i]);
        }
    }
}