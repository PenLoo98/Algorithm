import java.util.*;
import java.io.*;
public class _5427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            char[][] map = new char[height][width]; // 지도
            Queue<int[]> fireQueue = new LinkedList<>(); // 불의 위치를 담은 큐
            Queue<int[]> sgQueue = new LinkedList<>(); // 상근이의 위치를 담은 큐

            // 지도 입력받기
            for(int j=0;j<height;j++){
                String line = br.readLine();
                for(int k=0;k<width;k++){
                    map[j][k] = line.charAt(k);
                    if(map[j][k] == '*'){
                        fireQueue.add(new int[]{j,k});
                    }
                    if(map[j][k] == '@'){
                        sgQueue.add(new int[]{j,k}); // 상근이 출발 위치를 큐에 넣음
                    }
                }
            }

            boolean isEscaped = false; // 탈출 성공 여부
            int escapeTime = 0; // 탈출 시간

            while(!sgQueue.isEmpty()){
                escapeTime++;

                // 불 확산
                int fireSize = fireQueue.size();
                for(int j=0;j<fireSize;j++){
                    int[] cur = fireQueue.poll();
                    for(int k=0;k<4;k++){
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        if(nx < 0 || ny < 0 || nx >= height || ny >= width) continue; // 범위를 벗어나면 무시
                        if(map[nx][ny] == '.' || map[nx][ny] == '@'){ // 불이 번질 수 있는 곳이면 번지게 함
                            map[nx][ny] = '*';
                            fireQueue.add(new int[]{nx,ny});
                        }
                    }
                }

                // 상근 탐색
                int sangSize = sgQueue.size();
                for(int j=0;j<sangSize;j++){
                    int[] currentPosition = sgQueue.poll();
                    for(int k=0;k<4;k++){
                        // 상하좌우로 탐색할 좌표
                        int nx = currentPosition[0] + dx[k];
                        int ny = currentPosition[1] + dy[k];

                        // 탈출에 성공했다면 루프 종료
                        if(nx < 0 || ny < 0 || nx >= height || ny >= width){
                            isEscaped = true;
                            break;
                        }
                        // 갈 수 없거나, 이미 방문한 곳이면 무시
                        if(map[nx][ny] == '#' || map[nx][ny] == '*' || map[nx][ny] == '@') continue;
                        // 이동 가능한 곳이면 이동
                        if(map[nx][ny] == '.'){
                            map[nx][ny] = '@';
                            sgQueue.add(new int[]{nx,ny});
                        }
                    }
                    if(isEscaped) break;
                }
                if(isEscaped) break;
            }

            // 탈출 성공 여부에 따라 다른 출력
            if(isEscaped){
                System.out.println(escapeTime);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
