import java.util.*;
import java.io.*;

class _18126{
    static long result = 0;
    static ArrayList<Edge>[] map;
    static boolean[] visited;

    static class Edge{
        int destination;
        int length;
        
        public Edge(int destination, int length){
            this.destination = destination;
            this.length = length;

        }
        @Override
        public String toString() {
            return "["+destination + ", " + length + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i<=n; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i=1;i<=n-1;i++){
            st = new StringTokenizer(br.readLine());
            
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            map[source].add(new Edge(destination, length));
            map[destination].add(new Edge(source, length));
        }

        // 입력값 확인
        // for (int i = 1; i <= n; i++) {
        //     System.out.print("[");
        //     for (int j = 0; j < map[i].size(); j++) {
        //         Edge edge = map[i].get(j);
        //         if (j > 0) {
        //             System.out.print(", ");
        //         }
        //         System.out.print(edge.toString());
        //     }
        //     System.out.println("]");
        // }
        
        visited[1] = true;
        dfs(1, 0);

        System.out.println(result);
    }

    static void dfs(int cur, long distance){
        if(result < distance){
            result = distance;
        }

        for(Edge next : map[cur]){
            if(!visited[next.destination]){
                visited[next.destination] = true;
                dfs(next.destination, distance+next.length);
                visited[next.destination] = false;
            }
        }
    }
}