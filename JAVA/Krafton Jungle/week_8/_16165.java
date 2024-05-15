import java.io.*;
import java.util.*;

public class _16165 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 걸그룹의 수: 1 ≤ N ≤ 100
        int m = Integer.parseInt(st.nextToken()); // 문제의 수: 1 ≤ M ≤ 100

        // 걸그룹 정보 입력
        Map<String, String[]> groupInfo = new HashMap<String, String[]>();

        for(int i=0;i<n;i++){
            String groupName = br.readLine();
            int memberNum = Integer.parseInt(br.readLine());
            String[] member = new String[memberNum];
            for(int j=0;j<memberNum;j++){
                member[j] = br.readLine();
            }
            Arrays.sort(member); // 이름을 사전 순으로 정렬
            groupInfo.put(groupName, member); // 걸그룹 정보 저장
        }

        // 퀴즈 입력과 출력
        for(int i=0;i<m;i++){
            String quiz = br.readLine();
            int quizType = Integer.parseInt(br.readLine());

            // 0이면 quiz팀의 멤버 이름을 전부 출력
            if(quizType == 0){
                for(String member : groupInfo.get(quiz)){
                    System.out.println(member);
                }
            }
            // 1이면 quiz멤버의 그룹 이름 출력
            else if(quizType == 1){
                for(String groupName: groupInfo.keySet()){
                    if(Arrays.asList(groupInfo.get(groupName)).contains(quiz)){
                        System.out.println(groupName);
                        break;
                    }
                }
            }
        }
    }
}
