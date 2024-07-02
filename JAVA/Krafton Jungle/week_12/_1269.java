import java.util.*;
import java.io.*;
public class _1269 {
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // HashSet 사용해서 해당 키 탐색시간을 평균 O(1)로 했다.
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<aSize;i++){
            hashSet.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<bSize;i++){
            int input = Integer.parseInt(st.nextToken());
            // A와B가 겹치면 제거
            if(hashSet.contains(input)){
                hashSet.remove(input);
            }
            // A와 겹치지 않는 B원소는 추가
            else{
                hashSet.add(input);
            }
        }
        // 대칭 차집합 원소 수 출력
        System.out.println(hashSet.size());
    }
}