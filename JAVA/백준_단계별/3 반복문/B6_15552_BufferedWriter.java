import java.io.*;
import java.util.StringTokenizer;

public class B6_15552_BufferedWriter {

    public static void main(String[] args) throws IOException {
        // 1. 테스트 케이스 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            // 2. 결과 버퍼에 저장
            bw.write(Integer.toString(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
            bw.newLine();
        }

        // 3. 자원 해제
        br.close();
        bw.flush();
        bw.close();
    }
}