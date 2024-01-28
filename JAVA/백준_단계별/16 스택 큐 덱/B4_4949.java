import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4_4949 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 여러줄 입력 받기
        String line="";
        while(true){
            line = br.readLine();
            // "."을 기준으로 입력 멈추기
            if(line.equals(".")){
                break;
            }
            VPS_Test(line);
        }
        System.out.println(sb);
    }
    public static void VPS_Test(String line){
        line = line.replace(" ","");
        // 문자열에서 알파뱃에 해당하는 문자 제거하기
        line = line.replaceAll("[a-zA-Z]", "");
        Stack<String> stack = new Stack<>();

        for(int i=0;i<line.length()-1;i++){
            String input = String.valueOf(line.charAt(i));
            if(stack.isEmpty()){
                stack.push(input);
            }
            else if(stack.peek().equals("(")){
                if(input.equals(")")){
                    stack.pop();
                }
                else{
                    stack.push(input);
                }
            }
            else if(stack.peek().equals(")")){
                stack.push(input);
            }
            else if(stack.peek().equals("[")){
                if(input.equals("]")){
                    stack.pop();
                }
                else{
                    stack.push(input);
                }
            }
            else if(stack.peek().equals("]")){
                stack.push(input);
            }
        }
        if(stack.isEmpty()){
            sb.append("yes\n");
        }
        else{
            sb.append("no\n");
        }
    }
}
