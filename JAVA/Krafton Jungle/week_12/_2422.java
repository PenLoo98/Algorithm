import java.util.*;
import java.io.*;
public class _2422 {
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 아이스크림 종류의 수
        int m = Integer.parseInt(st.nextToken()); // 섞어먹으면 안되는 조합의 수
        boolean[][] isNotMix = new boolean[n+1][n+1]; // 섞어먹으면 안되는 조합 저장
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            isNotMix[x][y] = true;
            isNotMix[y][x] = true;
        }
        // 아이스크림 조합 계산
        int answer = 0;
        for(int i=1;i<=n-2;i++){
            for(int j=i+1;j<=n-1;j++){
                // 섞으면 안되는 경우 제외
                if(isNotMix[i][j]){continue;}
                for(int k=j+1;k<=n;k++){
                    // 섞으면 안되는 경우 제외
                    if(isNotMix[i][k] | isNotMix[j][k]){continue;}
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}