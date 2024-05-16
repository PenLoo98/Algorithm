import java.util.*;
import java.io.*;

public class _27313{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // n: 볼 애니메이션 갯수 1 ≤ N ≤ 100,000
        int m = Integer.parseInt(st.nextToken()); // m: 사용가능한 시간 0 ≤ M ≤ 10^9
        int k = Integer.parseInt(st.nextToken()); // k: 동시에 볼 수 있는 애니메이션 개수 1 ≤ K ≤ 100,000

        // n개의 애니메이션 보는 시간 입력
        st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> viewTime = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int inputViewTime = Integer.parseInt(st.nextToken());
            // 사용가능한 시간보다 작거나 같은 애니메이션만 볼 수 있음
            if(inputViewTime <= m){
                viewTime.add(inputViewTime);
            }
        }
        Collections.sort(viewTime); // 오름차순 정렬
        // dp[i]: i번째 애니메이션까지 볼 수 있는 최소 시간
        ArrayList<Integer> dp = new ArrayList<Integer>(); 
        if(viewTime.size() == 0){
            System.out.println("0");
            return;
        }
        int time = 0;
        for(int i=0;i<viewTime.size();i++){
            time = (i<k) ? viewTime.get(i) : dp.get(i-k) + viewTime.get(i);        
            
            if(time > m){
                break;
            }
            else{
                dp.add(time);
            }
        }
        
        System.out.println(dp.size());
        br.close();
    }   
}