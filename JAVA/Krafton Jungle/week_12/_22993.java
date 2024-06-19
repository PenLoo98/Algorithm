import java.util.*;
import java.io.*;
public class _22993 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] players = new long[n-1];
        long junwonAttack = 0; // 준원이의 공격력
        for(int i=0;i<n;i++){
            // 준원이의 공격력은 따로 저장
            if(i == 0){
                junwonAttack = Long.parseLong(st.nextToken());
                continue;
            }
            players[i-1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(players); // 준원이를 제외한 나머지 플레이어들의 공격력을 오름차순으로 정렬

        // System.out.println(junwonAttack);
        // System.out.println(Arrays.toString(players));

        for(int i=0;i<n-1;i++){
            long currentAttack = players[i]; // 현재 준원이가 마주친 플레이어 공격력
            // X>Y 
            if(junwonAttack > currentAttack){
                junwonAttack += currentAttack;
            }
            // X<=Y
            else{
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}