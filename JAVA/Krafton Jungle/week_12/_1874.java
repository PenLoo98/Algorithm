import java.io.*;
import java.util.*;

public class _1874 {
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int currentNum = 1; // 다음에 들어갈 숫자
        int inputNum; // 입력받은 수
        int topNum; // 스택 맨위 값

        for(int i=1;i<=n;i++){
            inputNum = Integer.parseInt(br.readLine());

            // 스택이 비어있는 경우
            if(stack.isEmpty()){
                for(int j=currentNum;j<=inputNum;j++){
                    stack.push(j);
                    sb.append("+\n");
                }
                currentNum = inputNum+1;
            } 
            // 스택이 채워져 있는 경우
            if(!stack.isEmpty()){
                topNum = stack.peek();

                // peek > inputNum인 경우 NO
                if(topNum > inputNum){
                    System.out.println("NO");
                    return;
                }
                // peek == inputNum인 경우 pop
                else if(topNum == inputNum){
                    stack.pop();
                    sb.append("-\n");
                }
                // peek < inputNum인 경우 push
                else if(topNum < inputNum){
                    for(int j=currentNum;j<=inputNum;j++){
                        stack.push(j);
                        sb.append("+\n");
                    }
                    currentNum = inputNum+1;
                    stack.pop();
                    sb.append("-\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}