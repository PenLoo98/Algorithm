import java.util.*;
import java.io.*;
public class _28250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int zero_count = 0;
        int one_count = 0;

        for(int i=0;i<n;i++){
            int input = Integer.parseInt(st.nextToken());
            if(input==0){
                zero_count++;
            }
            if(input==1){
                one_count++;
            }
        }
        int other_count = n-zero_count-one_count;
        long sum = 0;
        sum += (long)(zero_count-1)*(zero_count)/2; // 0 전부 세기
        sum += (long)zero_count*one_count*2; // 0과 1 세기
        sum += (long)zero_count*other_count; // 0과 2+ 세기

        System.out.println(sum);
    }
}