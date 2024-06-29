import java.util.*;
import java.io.*;
public class _1303 {
    static boolean[][] visited; // 방문 여부
    static int[] dx = new int[]{1,0,-1,0}; // 상하좌우 탐색
    static int[] dy = new int[]{0,-1,0,1}; // 상하좌우 탐색
    static int n,m;
    static char[][] map; // 전쟁터 상황

    static class Position{
        int y;
        int x;
        Position(int y,int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args)throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 가로
        m = Integer.parseInt(st.nextToken()); // 세로
        map = new char[m][n];
        visited = new boolean[m][n];
        
        int WPower = 0; // 우리 병사의 위력합
        int BPower = 0; // 적국 병상의 위력합

        // 전쟁터 상황판
        for(int i=0;i<m;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = line.charAt(j);
            }
        }

        // 전쟁터 상황판 입력 테스트
        // System.out.println(Arrays.deepToString(map));

        // 각 나라의 위력 계산
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 적국의 위력 계산
                if(!visited[i][j] & map[i][j]=='B'){
                    BPower += calculatePower(i, j, 'B');
                }
                // 우리의 위력 계산
                else if(!visited[i][j] & map[i][j]=='W'){
                    WPower += calculatePower(i, j, 'W');
                }
            }
        }
        System.out.println(WPower+" "+BPower); // 결과출력
    }
    // 특정 좌표와 팀의 병사의 위력 계산하는 함수
    static int calculatePower(int curY, int curX, char curCountry){
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(curY, curX));
        int count = 1;
        visited[curY][curX] = true;
        int nx = 0;
        int ny = 0;

        // 큐를 사용해 BFS로 탐색
        while(q.isEmpty()==false){
            Position pos = q.poll();
            int x = pos.x;
            int y = pos.y;
            
            for(int i=0;i<4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                // 영역을 벗어난 경우
                if(nx<0 | nx>n-1 | ny<0 | ny>m-1){
                    continue;
                }
                // 이미 탐색한 경우
                if(visited[ny][nx]){
                    continue;
                }
                // 같은 나라의 병사가 있는 경우
                if(map[ny][nx]==curCountry){
                    visited[ny][nx] = true; 
                    count++;
                    q.add(new Position(ny, nx));
                }
            }
        }
        return count * count;
    }
}