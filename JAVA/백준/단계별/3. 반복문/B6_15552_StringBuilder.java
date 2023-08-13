import java.io.*;
import java.util.StringTokenizer;

public class B6_15552_StringBuilder {
    public static void main(String[] args) throws IOException {
        // 1. 테스트 케이스 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
        }

        // 3. 자원 해제
        br.close();
        System.out.println(sb);
    }
}