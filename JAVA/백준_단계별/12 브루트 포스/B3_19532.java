import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_19532 {
    public static void main(String[] args) throws IOException {
        // a, b, c, d, e, f를 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] inputs = new Integer[6];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 6; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        int a = inputs[0];
        int b = inputs[1];
        int c = inputs[2];
        int d = inputs[3];
        int e = inputs[4];
        int f = inputs[5];

        // x,y를 구한다.
        int x = (c*e-b*f)/(a*e-b*d);
        int y = (c*d-a*f)/(b*d-a*e);

        // x,y 출력
        System.out.println(x+" "+y);
    }
}
