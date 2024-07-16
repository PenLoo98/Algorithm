import java.util.*;
import java.io.*;
public class _21736 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M]; // 지도
        boolean[][] visited = new boolean[N][M]; // 방문 여부
        Node doyeon = null; // 도연이의 위치
        int meetPeople = 0; // 도연이가 만난 사람 수
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j] == 'I'){
                    doyeon = new Node(i, j);
                }
            }
        }

        // 입력 확인
        // for(int i=0; i<N;i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<Node> q = new LinkedList<>();
        q.add(doyeon);
        visited[doyeon.x][doyeon.y] = true;

        // BFS
        while(!q.isEmpty()){
            Node current = q.poll();
            int x = current.x;
            int y = current.y;

            // 사람을 만나면 카운트 증가
            if(map[x][y] == 'P'){
                meetPeople++;
            }

            // 상하좌우 탐색
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;
                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }

        // 결과 출력
        if(meetPeople == 0){
            System.out.println("TT");
        }else{
            System.out.println(meetPeople);
        }
    }
}
