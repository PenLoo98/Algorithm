import java.util.*;
import java.io.*;
public class _14382 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for(int i=1;i<=t;i++){
            long n = Long.parseLong(br.readLine());

            if(n == 0){
                System.out.println("Case #" + i + ": INSOMNIA");
                continue;
            }

            boolean[] digit10 = new boolean[10]; // 0~9까지의 숫자가 있는지 확인
            int count = 1; // 더할 숫자
            long number = 0; // 결과값
            boolean isEnd = false; // 종료여부
            //
            while(true){
                number = n * (long)count++;
                long cur = number;
                // 10으로 나누면서 0~9까지의 숫자가 있는지 확인
                while(cur > 0){
                    digit10[(int)(cur % 10)] = true;
                    // 0~9까지의 숫자가 모두 채워지면 종료
                    if(checkDigit(digit10)){
                        isEnd = true;
                        break;
                    }
                    cur /= 10;
                }
                if(isEnd){
                    break;
                }
            }
            System.out.println("Case #"+i+": "+number);
        }
    }
    // 0~9까지의 숫자가 모두 있는지 확인하는 함수
    public static boolean checkDigit(boolean[] digit10){
        for(int i=0;i<10;i++){
            if(!digit10[i]){
                return false;
            }
        }
        return true;
    }
}
