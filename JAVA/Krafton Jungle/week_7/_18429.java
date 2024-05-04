import java.io.*;
import java.util.*;


public class _18429 {
    static int sumWeight = 0;
    static int caseCount = 0;
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] changeWeight = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            // 키트 증가량 - k해서 배열에 저장
            changeWeight[i] = Integer.parseInt(st.nextToken()) - k;
        }

        // 재귀적으로 모든 경우의 수를 탐색
        findCase(changeWeight, new boolean[n], n,0);

        System.out.println(caseCount);
    }

    public static void findCase(int[] changeWeight, boolean[] visited, int n, int depth){
        if(sumWeight < 0){
            return;
        }
        if(sumWeight >= 0 && depth == n){
            caseCount++;
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                sumWeight += changeWeight[i];
                findCase(changeWeight, visited, n, depth+1);
                visited[i] = false;
                sumWeight -= changeWeight[i];
            }
        }
        return;
    }
}
