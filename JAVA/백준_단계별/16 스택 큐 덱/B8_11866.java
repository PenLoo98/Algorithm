import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B8_11866 {
    public static void main(String[] args) throws IOException {
        // N,K 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        // 1~N까지 순서대로 queue 저장
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            queue.add(i);
        }

        sb.append("<");
        // K번째 회전
        while(queue.size() >1){
            // k번쨰만큼 회전
            for(int i=0;i<K-1;i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()+", ");
        }
        sb.append(queue.poll());
        sb.append(">");

        System.out.println(sb);
    }
}
