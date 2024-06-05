import java.util.*;
import java.io.*;

class _13549{
    static class Position{
        int x;
        int tick;
        Position(int x, int tick){
            this.x = x;
            this.tick = tick;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

       boolean[] visited = new boolean[100_001];
        Arrays.fill(visited, false);

        Deque<Position> q = new LinkedList<>();
        q.add(new Position(N, 0));
        visited[N] = true;
        int x, tick;

        while(!q.isEmpty()){
            // q에서 뽑아 현재 좌표를 확인한다. 
            Position current = q.poll();
            x = current.x;
            tick = current.tick;

            // K에 도착하면 갱신 
            if(x == K){
                System.out.println(tick);
                return;
            }
            // 순간이동 하는 경우 
            if(x*2<=100000 && !visited[x*2]){
                visited[x*2] = true;
                q.addFirst(new Position(x*2, tick));
            }
            // x-1하는 경우
            if(x-1>=0 && !visited[x-1]){
                visited[x-1] = true;
                q.addLast(new Position(x-1, tick+1));
            }
            // x+1하는 경우
            if(x+1<=100000 && !visited[x+1]){
                visited[x+1] = true;
                q.addLast(new Position(x+1, tick+1));
            }
        }
    }
}