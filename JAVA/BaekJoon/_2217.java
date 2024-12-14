import java.util.*;
import java.io.*;
public class _2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int maxWeight = 0;

        // 최대 중량은 가장 무거운 로프 중량 * 로프의 개수
        for(int i = 0; i < n; i++) {
            maxWeight = Math.max(maxWeight, arr[i] * (n - i));
        }
        
        System.out.println(maxWeight);
    }
}