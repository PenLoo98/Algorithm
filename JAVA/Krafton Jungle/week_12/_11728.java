import java.util.*;
import java.io.*;
public class _11728 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // A 배열 입력
        int[] A = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        A[n] = Integer.MAX_VALUE;

        // B 배열 입력
        int[] B = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        B[m] = Integer.MAX_VALUE;

        // A,B 배열 병합정렬로 합치기
        int a_index = 0;
        int b_index = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n+m;i++){
            if(A[a_index] <= B[b_index]){
                sb.append(A[a_index++]+" ");
            }
            else{
                sb.append(B[b_index++]+" ");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}