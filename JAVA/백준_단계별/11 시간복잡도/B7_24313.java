import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7_24313 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int fn = a1*n0 + a0;
        int cGn = c*n0;

        // 출력
        if(fn > cGn){
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }
    }
}