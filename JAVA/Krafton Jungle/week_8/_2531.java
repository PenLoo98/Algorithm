import java.io.*;
import java.util.*;

public class _2531 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 입력 받기 
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 접시의 수: 2 ≤ N ≤ 30,000
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수: 2 ≤ d ≤ 3,000
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수: 2 ≤ k ≤ 3,000 (k ≤ N)
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호: 1 ≤ c ≤ d

        // 초밥의 종류를 저장할 배열
        int[] belt = new int[n+k];
        for(int i=0;i<n;i++){
            belt[i] = Integer.parseInt(br.readLine());
        }

        // 처음에 먹을 수 있는 초밥의 가짓수를 구한다.
        int[] eatSushi = new int[d+1]; // 종류별로 먹은 초밥의 수
        eatSushi[c]++; // 쿠폰 초밥을 먹은 것으로 처리
        int curDiversity = 1; // 현재 먹을 수 있는 초밥의 가짓수, 쿠폰 미리 더하고 시작
        Queue<Integer> sushiQ = new LinkedList<Integer>();
        for(int i=0;i<k;i++){
            int inputIndex = i+n; // 초밥 벨트에서 n+k까지 붙이기 위해서 
            belt[inputIndex] = belt[i]; // 벨트의 끝에 n+k까지 붙이기

            if(eatSushi[belt[i]] == 0){
                curDiversity++; // 처음 먹는 초밥이면 가짓수 증가
            }
            eatSushi[belt[i]]++; // 먹은 초밥의 수 증가
            sushiQ.add(belt[i]); // 먹은 초밥의 번호를 큐에 저장
        }
        int maxDiversity = curDiversity; // 최대 먹을 수 있는 초밥의 가짓수

        for(int i=k;i<n+k;i++){
            int outSushi = sushiQ.poll(); // 맨 앞에 있는 초밥을 뺀다.
            eatSushi[outSushi]--; // 먹은 초밥의 수 감소
            if(eatSushi[outSushi] == 0){
                curDiversity--; // 먹은 초밥의 수가 0이면 가짓수 감소
            }

            int inSushi = belt[i]; // 새로운 초밥을 먹는다.
            if(eatSushi[inSushi] == 0 && inSushi != c){
                curDiversity++; // 처음 먹는 초밥이면 가짓수 증가
            }
            eatSushi[inSushi]++; // 먹은 초밥의 수 증가
            sushiQ.add(inSushi); // 먹은 초밥의 번호를 큐에 저장

            maxDiversity = Math.max(maxDiversity, curDiversity);
        }
        System.out.println(maxDiversity);
    }
}