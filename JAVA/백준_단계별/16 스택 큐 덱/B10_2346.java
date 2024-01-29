import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B10_2346 {
//    static Deque<Integer> deque = new ArrayDeque<>();

    static Deque<Integer> deque = new LinkedList<>();
    static Deque<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력
        Integer N = Integer.parseInt(br.readLine());

        // 종이 입력
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            deque.add(Integer.parseInt(st.nextToken()));
            queue.add(i+1);
        }

        // 회전
        while(deque.size()>1){
            // 덱 맨 앞의 값 출력
            int move = deque.pop();
            sb.append(queue.poll()+" ");

            // 터트려서 종이 수 만큼 이동
            if(move>0){
                for(int i=0;i<move-1;i++){
                    deque.addLast(deque.pop());
                    queue.addLast(queue.pop());
                }
            }
            else if(move<0){
                move = move*(-1);
                for(int i=0;i<move;i++){
                    deque.addFirst(deque.pollLast());
                    queue.addFirst(queue.pollLast());
                }
            }
        }
        sb.append(queue.poll());

        System.out.println(sb);
    }
}