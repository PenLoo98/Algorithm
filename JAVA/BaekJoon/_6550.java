import java.io.*;
import java.util.*;

public class _6550 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        // 여러개의 문자열 입력 
        while(true){
            String input = br.readLine();
            // 더 이상 입력이 되지 않으면 종료
            if(input==null){
                break;
            }
            st=new StringTokenizer(input);
            
            String s = st.nextToken();
            String t = st.nextToken();
            int index = 0;
            for(int i=0; i<t.length(); i++){
                if(t.charAt(i)==s.charAt(index)){
                    index++;
                    if(index==s.length()){
                        break;
                    }
                }
            }
            if(index==s.length()){
                sb.append("Yes"+"\n");
            }
            else{
                sb.append("No"+"\n");    
            }
        }

        // 마지막 개행문자 제거
        System.out.println(sb.toString());
        br.close();
    }
}