import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B6_18258 {
    static Deque<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (!command.equals("push")){
                commandQueue(command);
            }
            else{
                pushQueue(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.println(sb);
    }
    static void pushQueue(int input){
        queue.offer(input);
    }
    static void commandQueue(String command){
        switch (command){
            case "pop":
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(queue.poll()+"\n");
                }
                break;
            case "size":
                sb.append(queue.size()+"\n");
                break;
            case "empty":
                if(queue.isEmpty()){
                    sb.append("1\n");
                }
                else{
                    sb.append("0\n");
                }
                break;
            case "front":
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(queue.peek()+"\n");
                }
                break;
            case "back":
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(queue.getLast()+"\n");
                }
                break;
        }
    }
}