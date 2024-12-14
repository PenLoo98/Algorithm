import java.io.*;
import java.util.*;

public class _2422 {
    public static void main(String[] args) throws IOException{
        // nC3인 모든 조합을 구하고 [섞으면 안 되는 조합의 수]를 빼는 방식으로 풀이
        
        // 입력 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n: 아이스크림 종류, m: 섞어먹으면 안되는 조합의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;

        boolean[][] noMix = new boolean[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            noMix[a][b] = true;
            noMix[b][a] = true;
        }

        // nC3인 모든 조합을 구하고 [섞으면 안 되는 조합의 수]를 빼는 방식으로 풀이
        for(int i=1; i<=n-2; i++){
            for(int j=i+1; i<=n-1; i++){
                for(int k=j+1; i<=n; i++){
                  if(noMix[i][j]|| noMix[i][k] || noMix[j][k]){
                      continue;
                  }
                  count++;
                }
            }
        }

        // 출력
        System.out.println(count);
    }
}