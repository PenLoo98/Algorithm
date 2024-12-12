import java.io.*;
import java.util.*;

public class _16439 {
    static int n;
    static int m;
    static int[][] chickenFavor;
    static int totalMaxSatisfaction = 0;
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n명의 사람
        m = Integer.parseInt(st.nextToken()); // m명의 치킨 종류

        chickenFavor = new int[n][m]; // n명의 사람의 m종류의 치킨 각각의 만족도
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                chickenFavor[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // System.out.println(Arrays.deepToString(chickenFavor));

        // 재귀적으로 가능한 모든 조합의 만족도 계산
        boolean[] selecteChicken = new boolean[m]; // 치킨 선택하면 true
        chooseChicken(selecteChicken, 0);

        System.out.println(totalMaxSatisfaction);
    }

    // m종류 중 3종류 선택한 만족도를 계산
    static void chooseChicken(boolean[] selected, int count){
        // 종료 조건 
        if(count==3){
            // 만족도 계산 
            // 선택한 3종류 중에서 가장 만족도 높은 걸로 계산
            int currentTotalSatisfaction = 0;
            for(int i=0; i<n; i++){ // n명의 최대 만족도
                int maxSatisfaction = 0; // 1명의 최대 만족도
                for(int j=0; j<m; j++){
                    // 선택한 치킨이면서 가장 만족도가 높은 걸 선택
                    if(selected[j] && chickenFavor[i][j]> maxSatisfaction){
                        maxSatisfaction = chickenFavor[i][j];
                    }
                }
                currentTotalSatisfaction+=maxSatisfaction;
            }

            // 최대 만족도 갱신 여부 
            if(currentTotalSatisfaction > totalMaxSatisfaction){
                totalMaxSatisfaction = currentTotalSatisfaction;
            }

            // 종료 
            return ;
        }

        // 탐색 조건 
        for(int k=0; k<m; k++){
            if(selected[k]==false){
                selected[k]=true;
                chooseChicken(selected, count+1);
                selected[k]=false;
            }
        }
    }
}