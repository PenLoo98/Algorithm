import java.util.*;
import java.io.*;
public class _9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringTokenizer st;
        for(int i=0;i<t;i++){
            // 옷 종류별로 카운트 계산
            HashMap<String, Integer> hashClothes = new HashMap<>();
            int n = Integer.parseInt(br.readLine()); // 가진 옷 종류

            // 옷이 없는 경우
            if(n==0){
                System.out.println(0);
                continue;
            }

            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 옷 이름은 생략
                String type = st.nextToken();
                // 해당 키값이 없으면 value 1로 추가, 있으면 해당 키의 값을 1증가
                hashClothes.merge(type, 1, Integer::sum); 
            }
            // 해시맵의 모든 값을 리스트로 반환
            ArrayList<Integer> values = new ArrayList<>(hashClothes.values());
            // System.out.println(values.toString());
            long allCase = 1;
            for(Integer value: values){
                // allCase *= Math.pow(2, value);
                allCase *= value+1; // 입고 안 입고
            }
            allCase--; // 모두 안 입는 경우의 수 제외

            System.out.println(allCase);
        }
    }
}