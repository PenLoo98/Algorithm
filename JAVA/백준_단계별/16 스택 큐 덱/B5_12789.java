import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B5_12789 {
    static Stack<Integer> waitStack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        System.out.println(validCanGet(n, queue));
    }

    static String validCanGet(Integer n,Queue<Integer> queue){
        // 기다리는 스택 -> waitStack
        // 현재 입장할 숫자 enterNum=1

        // enterNum == queue.peek이면 "queue.poll + enterNum+=1"
        // waitStack이 비어있지 않으면서 enterNum == waitStack.peek이면 "waitStack.pop + enterNum+=1"
        // 아닌경우 waitStack.push(queue.poll)
        // enterNum<=n
        // waitStack과 queue가 비어있으면 "Nice" 아니면 "Sad"

        Integer enterNum = 1;
        while (!queue.isEmpty()){
            if(enterNum.equals(queue.peek())){
                queue.poll();
                enterNum+=1;
            }
            else if(!waitStack.isEmpty() && enterNum.equals(waitStack.peek())){
                waitStack.pop();
                enterNum+=1;
            }
            else{
                waitStack.push(queue.poll());
            }
        }
        while(!waitStack.isEmpty()){
            if(enterNum.equals(waitStack.peek())){
                waitStack.pop();
                enterNum+=1;
            }
            else{
                return "Sad";
            }
        }
        return "Nice";
    }
}
