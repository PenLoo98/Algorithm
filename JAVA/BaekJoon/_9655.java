import java.io.*;

public class _9655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String answer = "";
        // 상근이가 이기는 경우 - 홀수일 때 3*x+1
        // 창영이가 이기는 경우 - 짝수일 때 / 6=1 1 3 4
        // *3, *3+1, *3+2 세 종류의 수가 있는데

        // 1 3 5 7
        // 2 4 6 8
        
        // 3*1= 상근
        // 3*2= 창영

        // 3*0+1 = 상근
        // 3*1+1 = 창영 
        
        // 3*0+2 = 창영
        // 3*1+2 = 상근 
        
        // n을 3으로 나눈 몫과 나머지를 구한다. 
        int quotient = n/3;
        int remainder = n%3;

        switch(remainder){
            case 0:
                if(quotient%2==0){
                    answer="CY";
                }
                else {
                    answer="SK";
                }
                break;
            case 1:
                if(quotient%2==0){
                    answer="SK";
                }
                else {
                    answer="CY";
                }
                break;
            case 2:
                if(quotient%2==0){
                    answer="CY";
                }
                else {
                    answer="SK";
                }
                break;
            default:
                break;
        }

        System.out.println(answer);
    }
}
