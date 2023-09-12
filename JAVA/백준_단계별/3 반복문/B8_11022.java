import java.io.*;
import java.util.StringTokenizer;

public class B8_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        short n = Short.parseShort(br.readLine());

        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            short a = Short.parseShort(st.nextToken());
            short b = Short.parseShort(st.nextToken());

            bw.write("Case #"+i+": "+a+" + "+b+" = "+(a+b));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}