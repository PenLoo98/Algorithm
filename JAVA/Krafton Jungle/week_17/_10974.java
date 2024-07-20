import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
public class _10974 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Integer> q = new LinkedList<>();
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        permutaion(0);
        bw.flush();
    }
    public static void permutaion(int len) throws IOException{
        if (len==n){
            bw.write(q.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            bw.newLine();
            return;
        }
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                q.addLast(i);
                visited[i] = true;
                permutaion(len+1);
                q.removeLast();
                visited[i] = false;
            }
        }
    }
}