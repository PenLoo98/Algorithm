package ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660 {
    public static void main(String[] args) throws IOException {
        // N, M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 원본 2차원 배열 입력 받기
        int[][] A = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구간합 배열
        int[][] D = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                D[i][j] = A[i][j] + D[i-1][j] + D[i][j-1] - D[i-1][j-1];
            }
        }

        // 두 구간을 입력받고 범위사이의 구간합 구하기
        // S[x1,y1~x2,y2] = S[x2,y2] - S[x2,y1-1] - S[y2,x1-1] + S[x1-1,y1-1]
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println(result);
        }

    }
}
