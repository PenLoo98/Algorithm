import java.util.*;
import java.io.*;

public class _2503{
    static int answer;
    public static class NumberInfo{
        int num;
        int strike;
        int ball;
        NumberInfo(int num, int strike, int ball){
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 테스트 입력의 개수
        ArrayList<NumberInfo> list = new ArrayList<>(); // 테스트 입력을 저장하는 리스트
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            list.add(new NumberInfo(num, strike, ball));
        }
        answer = 0;
        isValidNumber(list); // 가능한 숫자 찾기
        System.out.println(answer);
    }

    static void isValidNumber(ArrayList<NumberInfo> list){
        
        // 첫번째 자리
        for(int j=1;j<=9;j++){
            // 두번째 자리
            for(int k=1;k<=9;k++){
                // 세번째 자리
                for(int l=1;l<=9;l++){
                    // 중복되는 숫자가 있는 경우
                    if(j==k || j==l || k==l){
                        continue;
                    }
                  
                    // 모든 조건을 만족하는지 확인
                    int checkCount = 0; // 테스트 입력을 만족하는지 확인하는 변수
                    for(NumberInfo info : list){
                        // strike와 ball이 같은 숫자인지 확인
                        int s = 0;
                        int b = 0;

                        int num = info.num;
                        int strike = info.strike;
                        int ball = info.ball;
                        
                        // strike 확인 - 숫자와 자리가 같으면 strike
                        if(j == num/100){
                            s++;
                        }
                        if(k == (num%100)/10){
                            s++;
                        }
                        if(l == num%10){
                            s++;
                        }
    
                        // ball 확인 - 숫자는 같지만 자리가 다르면 ball
                        if(j == (num%100)/10 || j == num%10){
                            b++;
                        }
                        if(k == num/100 || k == num%10){
                            b++;
                        }
                        if(l == num/100 || l == (num%100)/10){
                            b++;
                        }
                        
                        // 임의의 숫자의 s, b와 strike, ball가 다르면 정답이 될 수 없는 숫자이므로 
                        // 다음 숫자로 넘어간다.
                        if(s != strike || b != ball){
                            break;
                        }
                        checkCount++;
                    }
                    // 모든 테스트 입력을 만족하는 숫자인 경우 정답후보군에 추가
                    if(checkCount == list.size()){
                        answer++;
                    }
                }
            }
        }
    }
}