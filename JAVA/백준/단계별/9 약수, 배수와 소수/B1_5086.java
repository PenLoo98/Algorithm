import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_5086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A==0 && B==0){
                break;
            }
            else {
                int remain1 = A%B;
                int remain2 = B%A;

                // 1번째 숫자가 2번째 수의 약수인 경우
                if(remain2 == 0){
                    System.out.println("factor");
                    continue;
                }
                // 1번째 숫자가 2번째 수의 배수인 경우
                if(remain1 == 0){
                    System.out.println("multiple");
                    continue;
                }
                // 아무것도 아닌 경우
                System.out.println("neither");
            }
        }
    }
}