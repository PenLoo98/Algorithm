import java.util.*;
import java.io.*;

public class _15787 {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 기차의 수
        int m = Integer.parseInt(st.nextToken()); // 명령의 수

        int[][] train = new int[n][20]; // 각 기차의 상태
        // 입력 - 명령어 처리
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int cmdType = Integer.parseInt(st.nextToken()); // 명령어 타입
            int trainNum = Integer.parseInt(st.nextToken()) - 1; // 기차 번호
            if(cmdType==1 | cmdType==2){
                int seatNum = Integer.parseInt(st.nextToken()) - 1; // 좌석 번호
                // 1 i x: i번 기차의 x번 좌석에 사람을 태운다.
                if(cmdType==1){
                    train[trainNum][seatNum] = 1;
                }
                // 2 i x: i번 기차의 x번 좌석에 사람을 하차시킨다.
                else if(cmdType==2){
                    train[trainNum][seatNum] = 0;
                }
            } 
            else if(cmdType==3 | cmdType==4){
                // 3 i: i번 기차의 좌석을 모두 한 칸씩 뒤로 옮긴다.
                if(cmdType==3){
                    for(int j=19;j>0;j--){
                        train[trainNum][j] = train[trainNum][j-1];
                        train[trainNum][j-1] = 0;
                    }
                }
                // 4 i: i번 기차의 좌석을 모두 한 칸씩 앞으로 옮긴다.
                else if(cmdType==4){
                    for(int j=0;j<19;j++){
                        train[trainNum][j] = train[trainNum][j+1];
                        train[trainNum][j+1] = 0;
                    }
                }
            }
            else{
                System.out.println("Error: cmdType is not 1, 2, 3, 4");
            }
        }

        // 명령 후 중복된 기차 상태 제거 
        HashSet<String> setTrain = new HashSet<>();
        for(int i=0;i<n;i++){
            // 기차 상태를 문자열로 변환
            String str = "";
            for(int j=0;j<20;j++){
                str += train[i][j];
            }
            setTrain.add(str);
        }

        // 결과 출력
        System.out.println(setTrain.size());
    }
}