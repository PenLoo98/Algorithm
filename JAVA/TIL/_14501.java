import java.util.*;
import java.io.*;

public class _14501 {
    static int[][] schedules;
    static int[] price;
    static int n;

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        schedules = new int[n][2];
        price = new int[n+1]; // i일째에 벌 수 있는 가장 큰 수익

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            schedules[i][0]=Integer.parseInt(st.nextToken()); // T: 상담기간
            schedules[i][1]=Integer.parseInt(st.nextToken()); // P: 수익
        }

        // System.out.println(Arrays.deepToString(schedules));
         
        for(int i=0; i<n; i++){
            int T = schedules[i][0];
            int P = schedules[i][1];

            // i번째 날 상담을 건너뛰어도 최대 이익을 유지
            price[i+1] = Math.max(price[i+1], price[i]);

            // n일을 넘기지 않는다면
            if(i+T <= n){
                price[i+T]=Math.max(price[i+T], price[i]+P);
            }
        }

        // System.out.println(Arrays.toString(price));

        System.out.println(price[n]);
    }
}