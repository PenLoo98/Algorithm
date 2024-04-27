import java.io.*;
import java.util.*;

public class _10655 {
    public static void main(String[] args) throws IOException{
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        // 모든 체크포인트를 지날 때의 전체 거리 구하기
        int totalDistance = 0;
        int start_x = points[0][0];
        int start_y = points[0][1];
        for(int i=1;i<n;i++){
            totalDistance += Math.abs(start_x - points[i][0]) + Math.abs(start_y - points[i][1]);
            start_x = points[i][0];
            start_y = points[i][1];
        }

        // i번째 체크포인트를 빼면서 절약되는 거리 구하기 
        int[] saveDistances = new int[n];
        int saveDistance = 0;
        for(int i=1;i<n-1;i++){
            int beforeJump = Math.abs(points[i-1][0] - points[i][0]) + Math.abs(points[i-1][1] - points[i][1]) + Math.abs(points[i][0] - points[i+1][0]) + Math.abs(points[i][1] - points[i+1][1]);
            int afterJump = Math.abs(points[i-1][0] - points[i+1][0]) + Math.abs(points[i-1][1] - points[i+1][1]);
            saveDistance = beforeJump - afterJump;
            saveDistances[i] = saveDistance;
        }

        System.out.println(totalDistance - Arrays.stream(saveDistances).max().getAsInt());
    }
}