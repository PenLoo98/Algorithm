import java.util.*;
import java.io.*;
public class _20117 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 소의 수

        int[] cows = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 소 품질의 배열

        Arrays.sort(cows); // 오름차순 정렬

        // 가장 작은 품질의 소와 가장 큰 품질의 소를 묶어서 더한다.
        int result = 0;
        for(int i=0; i<n/2; i++){
            result += cows[n-1-i];
        }
        result *= 2;

        // 홀수면 중간값을 추가로 더해준다.
        if(n % 2 == 1){
            result += cows[n/2];
        }

        System.out.println(result);
    }
}