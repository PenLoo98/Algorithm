import java.util.*;
import java.io.*;
class _1697{
    static class Position{
        int position;
        int time;
        Position(int position, int time){
            this.position = position;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 출발 위치
        int K = Integer.parseInt(input[1]); // 도착 위치
        
        boolean[] visited = new boolean[100001]; // 위치로 방문 여부
        int[] times = new int[100_001]; // 위치로 방문시 지난 시간

        int minFindTime = Integer.MAX_VALUE; // 최소 시간

        Queue<Position> q = new LinkedList<>();
        q.add(new Position(N, 0));
        visited[N] = true;
        
        while(!q.isEmpty()){
            // 큐에서 현재 위치를 뽑는다.
            Position currentNode = q.poll();
            int curPos = currentNode.position;
            int curTime = currentNode.time;

            // 현재 위치가 K와 같다면
            if(curPos == K){
                if(minFindTime > curTime){
                    minFindTime = curTime;
                }  
                continue;
            }

            // 위치가 X일 때 1초 후에 X-1, X+1, 2*X로 이동할 수 있다.
            // 1초 뒤에 갈 수 있는 위치에 대해 큐에 넣는다.
            if(curPos-1 >= 0){
                if(visited[curPos-1]==false){
                    q.add(new Position(curPos-1, curTime+1));
                    visited[curPos-1] = true;
                    times[curPos-1] = curTime+1; 
                }
                // 이미 방문했지만 더 빠른 시간에 방문할 수 있다면 갱신
                else if(times[curPos-1] > curTime+1){
                    times[curPos-1] = curTime+1;
                }
            }
            if(curPos+1 <= 100000){
                if(visited[curPos+1]==false){
                    q.add(new Position(curPos+1, curTime+1));
                    visited[curPos+1] = true;
                    times[curPos+1] = curTime+1;
                }
                // 이미 방문했지만 더 빠른 시간에 방문할 수 있다면 갱신
                else if(times[curPos+1] > curTime+1){
                    times[curPos+1] = curTime+1;
                }
            }
            if(curPos*2 <= 100000){
                if(visited[curPos*2]==false){
                    q.add(new Position(curPos*2, curTime+1));
                    visited[curPos*2] = true;
                    times[curPos*2] = curTime+1;
                }
                // 이미 방문했지만 더 빠른 시간에 방문할 수 있다면 갱신
                else if(times[curPos*2] > curTime+1){
                    times[curPos*2] = curTime+1;
                }
            }
        }
        // 결과 출력 
        System.out.println(minFindTime);
    }
}