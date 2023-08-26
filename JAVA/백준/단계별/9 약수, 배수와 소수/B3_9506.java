import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B3_9506 {
    public static void main(String[] args) throws IOException {
        // 인스턴스 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // while 문
        while (true){
            int n = Integer.parseInt(br.readLine());

            // 입력이 -1인지 확인
            if(n == -1){
                break;
            }

            // 완전수인지 확인
            List<Integer> factors = new ArrayList<Integer>();
            factors.add(1);
            for(int i=2;i<n;i++){
                if(n%i==0){
                    factors.add(i);
                }
            }
            int sum = factors.stream().mapToInt(Integer::intValue).sum();

            // 완전수인 경우
            if(n==sum){
                System.out.printf("%d = 1",n);
                factors.stream()
                        .filter(num -> num !=1)
                        .map(num -> " + "+num)
                        .forEach(System.out::print);
                System.out.print("\n");
            }
            // 완전수가 아닌 경우
            else {
                System.out.printf("%d is NOT perfect.\n",n);
            }
        }
    }
}