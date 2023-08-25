import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3_2720 {
    public static void main(String[] args) throws IOException {
        // 테스트 케이스 T 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 거스름 돈 C 입력
        for(int i=0;i<T;i++){
            int C = Integer.parseInt(br.readLine());
            // 테스트: 194
            int m1 = C/25; //7
            int m2 = C%25/10; //1
            int m3 = C%25%10/5; //1
            int m4 = C%25%10%5; //4
            // 거스틈 돈에 맞는 4*1 행렬을 출력
            System.out.printf("%d %d %d %d%n",m1,m2,m3,m4);
        }
        br.close();
    }
}