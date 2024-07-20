import java.util.*;
import java.io.*;
public class _4963 {
    static int[][] map;
    static boolean[][] visited;
    static int islands;
    static int w;
    static int h;
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    static int nx;
    static int ny;
    static Queue<Position> q;

    static class Position{
        int y,x;
        Position(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            w=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());

            if(w==0 && h==0){
                break;
            }

            // 1: 땅, 0: 바다
            map = new int[h][w];
            visited = new boolean[h][w];
            islands = 0;

            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    // 방문하지 않았으면서 땅이면 탐색
                    if(!visited[i][j] && map[i][j]==1){
                        searchIsland(i, j);
                        islands++;
                    }
                }
            }
            
            bw.write(islands+"\n");
        }
        bw.flush();
        bw.close();
    }

    // 현재 좌표가 땅인데 이어진 가로세로대각선으로 이어진 땅은 visited=true로 처리하는 함수
    static void searchIsland(int curY, int curX){
        q = new LinkedList<>();
        q.add(new Position(curY, curX));
        visited[curY][curX]=true;

        while(!q.isEmpty()){
            Position curPos = q.poll();

            // 8방향 탐색
            for(int i=0;i<8;i++){
                ny = curPos.y+dy[i];
                nx = curPos.x+dx[i];
    
                // 범위를 벗어나는지 확인
                if(nx<0 | nx>=w | ny<0 | ny>=h){continue;};
                // 바다인지, 이미 방문했는지 확인
                if(map[ny][nx]==0 | visited[ny][nx]){continue;};
                
                q.add(new Position(ny, nx));
                visited[ny][nx]=true;
            }
        }
    }
}