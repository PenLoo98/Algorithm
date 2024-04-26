import java.util.*;
import java.io.*;

public class _1913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        sc.close();
        
        // 좌표 y,x

        // 달팽이 배열 채우기
        // 갈 수 있다의 기준은 배열의 범위를 넘어가지 않는 것+0이 아닌 값이 있는지 확인
        // 벽에 부딪히면 왼쪽 90도 방향 전환
        int[][] snail = new int[n][n];
        int num = n*n;
        int x=0, y=0;
        int dx = 1, dy = 0;
        int next_x, next_y;

        snail[0][0] = num;

        // 아래 (1,0) 오른쪽 (0,1) 위 (-1,0) 왼쪽 (0,-1)
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
        int directIndex = 0;

        while(true){
            
            next_x = x + dx;
            next_y = y + dy;

            // 배열 범위를 벗어나거나 이미 숫자가 채워진 경우 방향 전환
            if(next_x < 0 || next_x >= n || next_y < 0 || next_y >= n || snail[next_x][next_y] != 0){
                directIndex = (directIndex+1)%4;
                dx = direction[directIndex][0];
                dy = direction[directIndex][1];

                next_x = x + dx;
                next_y = y + dy;
            }
            
            snail[next_x][next_y] = --num;
            if(next_x == n/2 && next_y == n/2) {
                break;
            }
            x += dx;
            y += dy;
        }
    
        // 달팽이 배열 출력
        StringBuilder sb = new StringBuilder();
        int target_x = 0, target_y = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // 타겟의 좌표 찾기
                if(snail[i][j] == target){
                    target_x = i+1;
                    target_y = j+1;
                }
                sb.append(snail[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        
        // 타겟의 좌표 출력
        System.out.println(target_x+" "+target_y);
    }
}
