import java.util.*;
import java.io.*;

public class _2961 {
    public static void main(String[] args) throws IOException{
        // 입력 받기 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{s, b});
        }

        // 1개 고르는 경우~n개 고르는 경우의 신맛과 쓴맛의 차이를 구해야한다. 
        // 비트마스킹으로 1~2^n-1까지의 경우의 수를 구한다.
        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<(1<<n);i++){
            int sour = 1;
            int bitter = 0;
            for(int j=0;j<n;j++){ // j번째 재료를 사용할지 말지 결정
                if((i & (1<<j)) != 0){ 
                    sour *= list.get(j)[0]; // 신맛은 사용한 재료의 신맛의 곱
                    bitter += list.get(j)[1]; // 쓴맛은 사용한 재료의 쓴맛의 합
                }
            }
            // 신맛과 쓴맛의 차이가 최소인 경우를 찾는다.
            minDiff = Math.min(minDiff, Math.abs(sour-bitter));
        }
        System.out.println(minDiff);
    }
}