import java.io.*;
import java.util.*;

public class _17503 {
    static class Beer{
        int favor;
        int alcohol;
        public Beer(int favor, int alcohol){
            this.favor = favor;
            this.alcohol = alcohol;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n: 축제 기간, m: 채울 선호도 합, k: 맥주 종류의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // v: 맥주 선호도, c: 도수 레벨
        int[][] beer = new int[k][2];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            beer[i][0] = Integer.parseInt(st.nextToken()); // v:맥주 선호도
            beer[i][1] = Integer.parseInt(st.nextToken()); // c: 도수 레벨
        }

        // 도수 레벨 오름차순 -> 맥주 선호도 내림차순
        Arrays.sort(beer, (a, b)->{
            if(a[1] == b[1]){
                return b[0]-a[0];
            }
            return a[1]-b[1];
        });

        System.out.println(Arrays.deepToString(beer));

        // 적정 간 레벨 구하기
        int favorSum = 0;
        int maxRiverLevel = 0;
        // 선호도가 낮은 순으로 정렬해서 우선순위 큐에 넣음
        PriorityQueue<Beer> pq = new PriorityQueue<>((b1,b2)->b1.favor - b2.favor);

        // 첫 n개만큼 술을 마시고 선호도 합을 구한다. 
        for(int i=0;i<n;i++){
            pq.offer(new Beer(beer[i][0], beer[i][1]));
            favorSum += beer[i][0];
            maxRiverLevel = Math.max(maxRiverLevel, beer[i][1]);
        }

        if(favorSum >= m){
            System.out.println(maxRiverLevel);
            System.exit(0);
        }

        // 선호도 합이 목표 선호도 합 미만이면 
        // 선호도가 가장 낮은 술을 빼고 다음 술을 추가한다.
        for(int i=n;i<k;i++){
            Beer beerTemp = pq.poll();
            favorSum -= beerTemp.favor;
            favorSum += beer[i][0];
            maxRiverLevel = Math.max(maxRiverLevel, beer[i][1]);
            pq.offer(new Beer(beer[i][0], beer[i][1]));
            if(favorSum >= m){
                break;
            }
        }
        if(favorSum < m){
            System.out.println(-1);
        }
        else{
            System.out.println(maxRiverLevel);
        }
    }
}