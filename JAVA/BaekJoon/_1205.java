import java.util.*;
import java.io.*;

public class _1205 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 랭킹에 등록된 점수의 개수
        int newScore = Integer.parseInt(st.nextToken()); // 새로운 점수
        int p = Integer.parseInt(st.nextToken()); // 랭킹에 등록할 수 있는 점수의 수
        ArrayList<Integer> scores = new ArrayList<>();
        // 점수가 없는 경우
        if(n==0){
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            scores.add(Integer.parseInt(st.nextToken()));
        }
        // 내림차순 정렬 
        Collections.sort(scores, Collections.reverseOrder());
        // System.out.println(scores);
        
        // n<p: 랭킹에 자리가 남은 경우
        // n==p: 랭킹에 자리가 찬 경우
        // 새로운 점수보다 작은 점수가 있는 경우
        // 새로운 점수보다 작은 점수가 없는 경우

        // 랭킹에 자리가 남은 경우
        if(n<p){
            // 새로운 점수보다 작은 점수가 있는 경우
            for(int i=0; i<n; i++){
                if(scores.get(i)<newScore){
                    // i-1번째에 같은 점수들이 있는 경우
                    while(i>=1 && scores.get(i-1)==newScore){
                        i--;
                    }
                    System.out.println(i+1);
                    return;
                }
            }
            // 새로운 점수보다 작은 점수가 없는 경우
            // 이전에 같은 점수가 있는지 확인
            while(n>=1 && scores.get(n-1)==newScore){
                n--;
            }
            System.out.println(n+1);
        }
        // 랭킹에 자리가 찬 경우
        else if(n==p){
            // 새로운 점수보다 작은 점수가 있는 경우
            for(int i=0; i<p; i++){
                if(scores.get(i)<newScore){
                    // i-1번째에 같은 점수들이 있는 경우
                    while(i>=1 && scores.get(i-1)==newScore){
                        i--;
                    }
                    System.out.println(i+1);
                    return;
                }
            }
            // 새로운 점수보다 작은 점수가 없는 경우
            System.out.println(-1);
        }
    }
}