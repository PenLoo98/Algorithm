import java.util.*;
import java.io.*;

public class _25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String playType = st.nextToken();
        HashMap<String, Integer> players = new HashMap<>(); // 플레이어 이름 : 신청횟수
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String applicant = st.nextToken();
            // 새로 신청한 지원자인 경우
            if(players.get(applicant)==null){
                players.put(applicant, 1);
            }
            // 이미 신청한 사람인 경우 +1
            else{
                players.put(applicant, players.get(applicant)+1);
            }
        }

        // 신청한 사람의 이름의 종류의 수 
        int applicantSize = players.keySet().size();

        // 플레이할 게임의 종류에 따라 다르게 계산 
        switch (playType) {
            case "Y":
                System.out.println(applicantSize);
                break;
            case "F":
                System.out.println(applicantSize/2);
                break;
            case "O":
                System.out.println(applicantSize/3);
                break;
            default:
                break;
        }
    }
}