import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YetB1_2745 {
    public static void main(String[] args) throws IOException {
        // 인스턴스 생성, 배열생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // N,B 입력
        String N = st.nextToken();
        StringBuilder sb = new StringBuilder(N);
        N = sb.reverse().toString();
        int B = Integer.parseInt(st.nextToken());
        br.close();
        int n = 'A'-55;

        // 진법 변환
        int sum = 0;
        System.out.println('A'-55);

//        for(int i=0;i<N.length();i++){
//            char n = N.charAt(i);
//            if("A"<=n )
//        }

        // 결과 출력
//        System.out.println(sum);
    }
}