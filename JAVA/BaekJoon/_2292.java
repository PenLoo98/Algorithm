import java.io.*;

public class _2292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine()) - 1;

        Integer count = 1;
        Integer cycle = 1;
        while(n>0){
            n-=6*cycle;
            count++;
            cycle++;
        }

        System.out.println(count);
    }    
}