import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B3_9012 {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String input = br.readLine();
            VPS_Test(input);
        }
        System.out.println(sb);
    }

    public static void VPS_Test(String inputs){
        Stack<String> stack = new Stack<>();
        for(int i=0;i<inputs.length();i++){
            String input = String.valueOf(inputs.charAt(i));

            if(stack.isEmpty()){
                stack.push(input);
            }
            else if(stack.peek().equals("(")){
                if(input.equals(")")){
                    stack.remove(stack.size()-1);
                } else if (input.equals("(")) {
                    stack.push(input);
                }
            }
            else if(stack.peek().equals(")")){
                if(input.equals(")")){
                    stack.push(input);
                } else if (input.equals("(")) {
                    stack.push(input);
                }
            }
        }
        // 스택이 비었으면 Yes 반환
        if(stack.isEmpty()){
            sb.append("YES\n");
        }
        else{
            sb.append("NO\n");
        }
    }
}
