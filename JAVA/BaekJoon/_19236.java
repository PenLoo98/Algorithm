import java.util.*;
import java.io.*;

class _19236 {
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int answer = 0;
    
    static class Fish {
        int num;
        int x;
        int y;
        int dir;
        Fish(int num, int x, int y, int dir) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[4][4]; // 어디 위치에 물고기가 있는지 확인
        Fish[] fish = new Fish[17]; // n번째 물고기가 있는지 확인, null이면 상어에게 먹힘
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                fish[a] = new Fish(a, i, j, b);
                map[i][j] = a;
            }
        }
        int dir = fish[map[0][0]].dir;
        int eat = map[0][0];
        fish[map[0][0]] = null;
        map[0][0] = -1;
        dfs(map, fish, 0, 0, dir, eat);
        System.out.println(answer);
    }
    
    public static void dfs(int[][] map, Fish[] fish, int x, int y, int dir, int sum) {
        answer = Math.max(answer, sum);

        int[][] copyMap = new int[4][4];
        Fish[] copyFish = new Fish[17];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        for(int i = 1; i <= 16; i++) {
            if(fish[i] != null) {
                copyFish[i] = new Fish(fish[i].num, fish[i].x, fish[i].y, fish[i].dir);
            }
        }

        // 물고기 이동
        for(int i = 1; i <= 16; i++) {
            if(copyFish[i] == null) continue;
            Fish f = copyFish[i];
            // 8방향 탐색
            for(int j = 0; j < 8; j++) {
                int ndir = (f.dir + j - 1) % 8 + 1;
                int nx = f.x + dx[ndir];
                int ny = f.y + dy[ndir];
                if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && copyMap[nx][ny] != -1) {
                    if(copyMap[nx][ny] == 0) {
                        copyMap[f.x][f.y] = 0;
                    } 
                    else {
                        int temp = copyMap[nx][ny];
                        copyMap[f.x][f.y] = temp;
                        copyFish[temp].x = f.x;
                        copyFish[temp].y = f.y;
                    }
                    copyMap[nx][ny] = f.num;
                    copyFish[f.num] = new Fish(f.num, nx, ny, ndir);
                    break;
                }
            }
        }

        // 상어 이동
        for(int i = 1; i <= 3; i++) {
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;
            if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;
            if(copyMap[nx][ny] == 0) continue;
            int num = copyMap[nx][ny];
            int ndir = copyFish[num].dir;
            copyMap[x][y] = 0;
            copyMap[nx][ny] = -1;
            copyFish[num] = null;
            dfs(copyMap, copyFish, nx, ny, ndir, sum + num);
            copyMap[x][y] = -1;
            copyMap[nx][ny] = num;
            copyFish[num] = new Fish(num, nx, ny, ndir);
        }
    }
}