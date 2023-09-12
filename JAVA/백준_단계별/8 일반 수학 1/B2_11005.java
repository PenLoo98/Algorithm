import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_11005{
    public static void main(String[] args) throws IOException{
        // 10진법 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // %B 하고 결과를 저장하기
        StringBuilder sb = new StringBuilder();
        while(N!=0){
            int m = N/B;
            int r = N%B;
            N = m;
            if(r <= 9){
                sb.append(r);
            }
            else {
                // 10이상의 수 변환하여 저장
                char R = (char)(r+55);
                sb.append(R);
            }
        }

        // 저장한 문자 배열을 합치기
        sb.reverse();
        System.out.println(sb);
    }
}