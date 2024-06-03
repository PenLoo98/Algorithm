import java.util.*;
import java.io.*;

public class _2206 {
    static int minMove = Integer.MAX_VALUE;
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][][] visited;

    static class Position{
        int x;
        int y;
        int move; // 이동거리
        boolean isBroaken; // 벽을 부순 유무

        public Position(int x, int y, int move, boolean isBroaken){
            this.x = x;
            this.y = y;
            this.move = move;
            this.isBroaken = isBroaken;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1]; // 좌표의 0,1로 채운다. 
        // 0행과 0열은 -1로 초기화
        for(int i=0; i<map.length; i++){
            Arrays.fill(map[i], -1);
        }
        visited = new boolean[n+1][m+1][2]; // 벽을 부순 경우와 부수지 않은 경우를 나누어서 방문처리

        // 0,1 입력값 받고 map에 저장
        for(int i=1;i<=n;i++){
            String input = br.readLine();
            for(int j=1;j<=m;j++){
                int inputNum = Character.getNumericValue(input.charAt(j-1)); // string -> char -> int
                map[i][j] = inputNum;
            }
        }

        bfs(1,1); // bfs로 탐색

        System.out.println(minMove); // 도착지점에 최소 이동거리 출력  
    }

    static void bfs(int x, int y){
        // 시작점 방문처리 
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x, y, 1, false));
        visited[x][y][0] = true;

        // 현재 좌표정보에서 queue에서 꺼내서 상하좌우 탐색
        while (q.isEmpty()==false){
            // 현재 좌표정보
            Position curPosition = q.poll();
            int curX = curPosition.x;
            int curY = curPosition.y;
            int curMove = curPosition.move;
            boolean curBroaken = curPosition.isBroaken;
            
            // 도착지점에 도달하면 이동거리 최소값으로 갱신
            if(curX == n && curY == m){
                if(minMove > curMove ){
                    minMove = curMove;
                }
            }

            // 상하좌우 탐색
            for(int i=0;i<4;i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < 1 || nextX > n || nextY < 1 || nextY > m){
                    continue;
                }
                // 방문하지 않은 경우에만 탐색
                if (!visited[nextX][nextY][curBroaken ? 1 : 0]){
                    // 벽이면서 아직 부수지 않은 경우
                    if (map[nextX][nextY] == 1 && !curBroaken){
                        q.add(new Position(nextX, nextY, curMove+1, true));
                        visited[nextX][nextY][1] = true;
                    }
                    // 이동할 수 있는 경우
                    else if (map[nextX][nextY] == 0){
                        q.add(new Position(nextX, nextY, curMove+1, curBroaken));
                        visited[nextX][nextY][curBroaken ? 1 : 0] = true;
                    }
                }
            }
        }

        // 도착지점에 도달하지 못한 경우
        if (minMove == Integer.MAX_VALUE){
            minMove = -1;
        }
        return;
    }
}