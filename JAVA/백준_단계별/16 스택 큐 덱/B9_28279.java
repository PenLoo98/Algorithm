import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B9_28279 {
    static Deque<Integer> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int command = Integer.parseInt(st.nextToken());
            if(command==1 || command==2){
                int input = Integer.parseInt(st.nextToken());
                commandInputDequeue(command,input);
            }
            else {
                commandDequeue(command);
            }
        }
        System.out.println(sb);
    }
    static void commandInputDequeue(int command, int input){
        switch (command){
            case 1:
                deque.addFirst(input);
                break;
            case 2:
                deque.addLast(input);
                break;
        }
    }
    static void commandDequeue(int command){
        switch (command){
            case 3:
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(deque.poll()).append("\n");
                }
                break;
            case 4:
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.getLast()).append("\n");
                    deque.removeLast();
                }
                break;
            case 5:
                sb.append(deque.size()).append("\n");
                break;
            case 6:
                if(deque.isEmpty()){
                    sb.append("1\n");
                }
                else{
                    sb.append("0\n");
                }
                break;
            case 7:
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.getFirst()).append("\n");
                }
                break;
            case 8:
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.getLast()).append("\n");
                }
                break;
        }
    }
}
