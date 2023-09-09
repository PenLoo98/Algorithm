import java.io.*;
import java.util.StringTokenizer;

public class B12_10951 {
    public static void main(String[] args) throws IOException {
        // 1. 입력받을 인스턴스
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;

        // 2. 입력
        while( (str=br.readLine()) != null ){
            st = new StringTokenizer(str, " ");
            short a = Short.parseShort(st.nextToken());
            short b = Short.parseShort(st.nextToken());
            sb.append(a+b).append("\n");
        }
        System.out.println(sb);
    }
}