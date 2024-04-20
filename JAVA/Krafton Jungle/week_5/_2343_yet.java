import java.util.*;
import java.io.*;
public class _2343_yet {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n,m 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 강의 입력
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        for(int i=0; i<n; i++){
            // 강의 시간 중 가장 긴 시간
            start = Math.max(start, arr[i]);
            // 모든 강의 시간의 합
            end += arr[i];
        }

        // 이진 탐색
        while(start <= end){
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 1;
            for(int i=0; i<n; i++){
                if(sum + arr[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if(cnt <= m){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
    
}
