import java.util.*;
import java.io.*;

public class _11723 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer total = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> S = new ArrayList<>();
        for (int i=0; i<total;i++){
            st = new StringTokenizer(br.readLine());
            String input1 = st.nextToken();
            Integer input2=0;
            if(st.hasMoreTokens()){
                input2 = Integer.parseInt(st.nextToken());
            }
            switch (input1) {
                case "all":
                    S = new ArrayList<>();
                    for (int j=1;j<=20;j++){
                        S.add(j);
                    }
                    break;

                case "empty":
                    S = new ArrayList<>();
                    break;

                case "add": 
                    // 포함하고 있지 않으면서 input2가 유효한 값이면
                    if(!S.contains(input2) & input2!=0){
                        S.add(input2);
                    }
                    break;

                case "remove":
                    // 포함하고 있으면서 input2가 유효한 값이면
                    if(S.contains(input2) & input2!=0){
                        S.remove(input2);
                    }
                    break;
                    
                case "check":
                    // 포함하고 있으면서 input2가 유효한 값이면
                    if(S.contains(input2) & input2!=0){
                        bw.write(1+"\n");
                    }
                    else{
                        bw.write(0+"\n");
                    }
                    break;
                    
                case "toggle":
                    // 포함하고 있지 않으면서 input2가 유효한 값이면
                    if(!S.contains(input2) & input2!=0){
                        S.add(input2);
                    }
                    // 포함하고 있으면서 input2가 유효한 값이면
                    else if(S.contains(input2) & input2!=0){
                        S.remove(input2);
                    }

                default:
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }    
}