import java.util.*;
import java.io.*;
public class _1012 {
    static int[][] map; // 배추밭
    static boolean[][] visited; // 방문여부
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        // 테스트 케이스만큼 반복
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
            int n = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
            int k = Integer.parseInt(st.nextToken()); // 심은 배추의 개수

            map = new int[n][m]; // 배추밭
            visited = new boolean[n][m]; // 방문여부

            // 배추 심기
            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            // 상하좌우로 배추가 이어져있는지 확인
            int answer = 0;
            for(int j=0;j<n;j++){
                for(int l=0;l<m;l++){
                    if(map[j][l] == 1 && !visited[j][l]){
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{j, l});
                        bfs(q);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    static void bfs(Queue<int[]> q){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            // 상하좌우 탐색
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어나거나 배추가 없는 경우
                if(nx<0 || nx>=map.length || ny<0 || ny>=map[0].length || map[nx][ny] == 0){
                    continue;
                }
                // 이미 방문한 경우
                if(visited[nx][ny]){
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
