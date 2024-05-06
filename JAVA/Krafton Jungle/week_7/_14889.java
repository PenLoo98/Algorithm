import java.util.*;
import java.io.*;
public class _14889 {
    static int n;
    static int[][] ability;
    static boolean[] select;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ability = new int[n][n]; // 팀원 i,j가 있을 때 향상되는 능력치
        select = new boolean[n+1]; // 팀원 조합의 선택 여부를 저장한 배열
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // N명 중에서 N/2명을 뽑는 모든 조합을 구한다.
        divideHalf(0, 0);
        System.out.println(minValue);
    }

    // 두 팀의 능력치 차이를 구하는 함수
    static void getAbilityDiff(){
        int teamStart = 0;
        int teamLink = 0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(select[i] && select[j]){
                    teamStart += ability[i][j] + ability[j][i];
                }
                else if(select[i]==false && select[j]==false){
                    teamLink += ability[i][j] + ability[j][i];
                }
            }
        }
        int diff = Math.abs(teamStart - teamLink);
        // 차이가 0이면 무조건 정답이 되므로 0을 출력하고 종료
        if(diff==0){
            System.out.println(0);
            System.exit(0);
        }
        minValue = Math.min(minValue, diff);
    }

    // 두 팀으로 나눈 조합을 재귀적으로 구하는 함수
    static void divideHalf(int idx, int member){
        if(member == n/2){
            getAbilityDiff();
            return;
        }
        for(int i=idx;i<n;i++){
            if(select[i]==false){
                select[i]=true;
                divideHalf(i+1, member+1);
                select[i]=false;
            }
        }
    }
}