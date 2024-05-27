import java.util.*;
import java.io.*;

public class _10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> card = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            card.put(Integer.parseInt(st.nextToken()), 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<m;i++){
            try{
                if(1==card.get(Integer.parseInt(st.nextToken()))){
                    bw.write("1 ");
                }
            }
            catch(NullPointerException e){
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}