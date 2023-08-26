import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2_2501 {
    public static void main(String[] args) throws IOException {
        // N, K 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // N의 약수의 집합을 오름차순으로 정렬
        List<Integer> factors = new ArrayList<Integer>();
        factors.add(1);
        for(int i=2;i<N;i++){
            if(N%i==0){
                factors.add(i);
            }
        }
        factors.add(N);

        // K번째 수가 존재하는지 확인
        if(factors.size() < K){
            System.out.println(0);
        }
        // 존재한다면 K번째 수 출력
        else {
            System.out.println(factors.get(K - 1));
        }
    }
}