import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4_1018 {
    public static void main(String[] args) throws IOException{
        // N, M 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 보드 입력
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

//        // 보드 입력값 출력
//        for(int j=0; j<N; j++){
//            for(int k=0; k<M; k++){
//                System.out.print(board[j][k]);
//            }
//            System.out.println();
//        }

        // 8*8로 자르기

        // W로 시작하는 경우와 B로 시작하는 경우를 나누어서 최소값을 구한다.
        // W로 시작하는 경우
        int count = 0;
        for(int i=0; i<N; i++){
            // 홀수 줄일 때
            if(i%2==0){
                for(int j=0; j<M; j++){
                    if(j%2==0 && board[i][j]=='B'){
                        count++;
                    }
                    else if (j%2==1 && board[i][j]=='W') {
                        count++;
                    }
                }
            }
            // 짝수 줄일 때
            else {
                for(int j=0; j<M; j++){
                    if(j%2==0 && board[i][j]=='W'){
                        count++;
                    }
                    else if (j%2==1 && board[i][j]=='B') {
                        count++;
                    }
                }
            }
        }
        count = Math.min(count, 64-count);

        System.out.println(count);
    }
}
