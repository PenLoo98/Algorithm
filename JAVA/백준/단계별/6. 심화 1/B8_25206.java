import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B8_25206 {
    public static void main(String[] args) throws IOException {
        // 1. 변수,객체 할당
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sumScore = 0;
        double sumCredit = 0;
        String inputs[] = new String[20];
        String[] gradeList = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] gradeScore = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

        // 2. for문으로 입력받고 계산
        for(int i=0;i<20;i++){
            inputs[i] = br.readLine();
            StringTokenizer st = new StringTokenizer(inputs[i], " ");

            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String Third = st.nextToken();

            // 평점 구하기
            for(int j=0;j<9;j++){
                if(Third.equals(gradeList[j])){
                    sumScore += credit*gradeScore[j];
                    sumCredit += credit;
                }
            }
        }

        // 3. 결과값 출력
        System.out.printf("%.6f", sumScore/sumCredit);
        br.close();
    }
}