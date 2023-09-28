package ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660 {
    public static void main(String[] args) throws IOException {
        // N, M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int M = Integer.parseInt(input[1]);
        int N = 4;
        int M = 3;

//        // 원본 2차원 배열 입력 받기
//        int[][] two_dimension = new int[N][N];
//        for(int i=0;i<N;i++){
//            String[] elements = br.readLine().split(" ");
//            for(int j=0;j<N;j++){
//                two_dimension[i][j] = Integer.parseInt(elements[j]);
//            }
//        }
////        // 입력할 2차원 배열 출력
////        for(int i=0;i<N;i++){
////            for(int j=0;j<N;j++){
////                System.out.print(two_dimension[i][j]);
////            }
////            System.out.println();
////        }
        int[][] two_dimension = {{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};

        // 구간 합 즐의 받고 대답하기

        // 구간합 배열 구하기
        int[][] traverse_Sum = new int[N][N];
        traverse_Sum[0][0] = two_dimension[0][0];
        // 1행 구간합 구하기
        for(int i=1;i<N;i++){
            // S[i][j] = A[i][j] + S[i][j-1]
            traverse_Sum[0][i] = two_dimension[0][i] + traverse_Sum[0][i-1];
        }
        // 1열 구간합 구하기
        for(int i=1;i<N;i++){
            // S[i][j] = A[i][j] + S[i-1][j]
            traverse_Sum[i][0] = two_dimension[i][0] + traverse_Sum[i-1][0];
        }
        // 나머지 행과열 구간합 구하기
        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                traverse_Sum[i][j] = two_dimension[i][j] + traverse_Sum[i-1][j] + traverse_Sum[i][j-1] - traverse_Sum[i-1][j-1];
            }
        }

        // S[i][j] = A[i][j]+S[i-1][j]+S[i][j-1]-S[i-1][j-1]
//        // 행렬 출력
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.print(traverse_Sum[i][j]+" ");
//            }
//            System.out.println();
//        }

        // 두 구간을 입력받고 범위사이의 구간합 구하기
        // S[x1,y1~x2,y2] = S[x2,y2] - S[x2,y1-1] - S[y2,x1-1] + S[x1-1,y1-1]
        // 두 구간 입력
        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            // [1,1] [4,4]
            if(x1==0 & y1==0){

            }
            int result = traverse_Sum[y2][x2]-traverse_Sum[y1-1][x2]-traverse_Sum[y2][x1-1]+traverse_Sum[y1-1][x1-1];
            System.out.println(result);
        }

    }
}
