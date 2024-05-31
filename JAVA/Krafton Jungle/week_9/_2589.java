import java.util.*;
import java.io.*;

public class _2589 {
    static int maxMove = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int height;
    static int width;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new char[height][width];
        for(int i=0;i<height;i++){
            st = new StringTokenizer(br.readLine());
            String oneLine = st.nextToken();
            for(int j=0;j<width;j++){
                map[i][j] = oneLine.charAt(j);
            }
        }
        // System.out.println(Arrays.deepToString(map));

        // 육지 두 점 사이의 최장거리 찾기 
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(map[i][j]=='L'){
                    visited = new boolean[height][width]; // 탐색을 시작할 때 visited를 초기화해준다.
                    int result = bfs(j,i); // map 기준으로 [y][x]이므로 뒤집어서 넣어준다.
                    maxMove = Math.max(maxMove, result);
                }
            }
        }

        // 어떻게 육지와 바다를 나눠서 탐색할 수 있을까?
        // -> map[ny][nx]='L'인 경우에만 탐색하면 될듯

        System.out.println(maxMove);
    }
    static int bfs(int curX, int curY){
        Queue<int[]> q = new LinkedList<>();
        
        int moveCount = 0;
        visited[curY][curX] = true;
        q.add(new int[] {curX, curY, 0});

        while(!q.isEmpty()){
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];
            int move = position[2];

            if(move > moveCount){
                moveCount = move;
            }

            for(int i=0;i<4;i++){
                int nx = px + directions[i][0];
                int ny = py + directions[i][1];
                if(nx<0 || nx>(width-1) || ny<0 || ny>(height-1)){
                    continue; // 영역을 벗어나면 다음으로 이동
                }
                if(!visited[ny][nx] && map[ny][nx]=='L'){
                    visited[ny][nx] = true;
                    q.add(new int[]{nx, ny, move+1});
                }
            }
        }

        return moveCount;
    }
}