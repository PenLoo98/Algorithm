import java.util.*;
import java.io.*;
public class _1325 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i=1; i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        // 
        // for(List<Integer> node: graph){
        //     System.out.println(node);
        // }

        int[] result = new int[n + 1]; // 각 컴퓨터가 해킹할 수 있는 컴퓨터의 수
        int maxHacks = 0; // 1번 해킹으로 가장 많은 컴퓨터를 해킹할 수 있는 수

        for(int i=1; i<=n;i++){
            boolean[] visited = new boolean[n+1];
            int count = bfs(graph, visited, i);
            result[i] = count;
            maxHacks = Math.max(maxHacks, count);
        }

        for(int i=1; i<=n; i++){
            if(result[i] == maxHacks){
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    static int bfs(List<Integer>[] graph, boolean[] visited, int index){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int i=0; i<graph[node].size(); i++){
                int next = graph[node].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return count;
    }
}