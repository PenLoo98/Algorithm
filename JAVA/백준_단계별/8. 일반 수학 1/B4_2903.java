import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4_2903 {
    public static void main(String[] args) throws IOException {
        // N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 점의 수 출력
        // (1,9) (2,25) ... (5,1089)

        // 0 -> 점 4개 -> 2*2
        // 1 -> 점 9개 -> 3*3 -> 3=2+1
        // 2 -> 점 25개 -> 5*5 -> 5=2*(2^(2-1))+1
        // 3 -> 점 ??개 -> 9*9 -> 9=2*(2^(3-1))+1
        // 4 -> 점 ??개 -> 17*17 -> 17=2*(2^(4-1))+1
        // 5 -> 점 1089개 -> 33*33 -> 33=2*(2^(5-1))+1
        // n = 2*(2^(n-1))+1

        int n = (int)(2*(Math.pow(2,N-1))+1);
        int result = n*n;
        System.out.println(result);
    }
}