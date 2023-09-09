import java.io.*;
import java.util.StringTokenizer;

public class B11_10952 {
    public static void main(String[] args) throws IOException {
        // 1. 입력받을 인스턴스
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 2. 입력
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            short a = Short.parseShort(st.nextToken());
            short b = Short.parseShort(st.nextToken());


            if(a==0 & b==0){
                break;
            }

            bw.write(""+(a+b));
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}