import java.io.*;
import java.util.*;

public class _26085 {
    public static void main(String[] args) throws IOException{
        // 입력 받기 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int zeroCount = 0;
        int oneCount = 0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==0){
                    zeroCount++;
                }
                else{
                    oneCount++;
                }
            }
        }

        // 0 또는 1의 갯수가 홀수개인 경우
        if(zeroCount%2==1 || oneCount%2==1){
            System.out.println(-1);
            return;
        }

        // 0과 1이 모두 짝수개인 경우
        int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        // 상하좌우 같은 값을 가지는지 확인
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // 현재 위치값
                int cur = board[i][j];

                // 4방향 각 위치값 확인
                for(int k=0;k<4;k++){
                    int ni = i+direction[k][0];
                    int nj = j+direction[k][1];
                    if(ni<0 || ni>=n || nj<0 || nj>=m){
                        continue;
                    }
                    // 범위 안에 있으면서 같은 값이 나오면 1출력
                    else{
                        if(cur==board[ni][nj]){
                            System.out.println(1);
                            return;
                        }
                    }                    
                }
            }
        }
        // 여기까지 오면 하나라도 없었다는 뜻이므로 -1 출력
        System.out.println(-1);
        return;
    }
}