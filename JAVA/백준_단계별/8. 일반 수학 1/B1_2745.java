import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_2745 {
    public static void main(String[] args) throws IOException {
        // 인스턴스 생성, 배열생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        br.close();

        int sum = 0;
        for(int i=0;i<N.length();i++){
            char c = N.charAt(i);
            if('0'<=c & '9'>=c){
                sum = sum*B + ((int)c - (int)'0');
            }
            else {
                sum = sum*B + ((int)c - (int)'A' + 10);
            }
        }
        System.out.println(sum);
    }
}