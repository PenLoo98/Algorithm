import java.io.*;

public class _1259{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String inputNumber = br.readLine();

            // 입력값이 0이면 종료
            if(inputNumber.equals("0")){
                break;
            }
            // 팰린드롬 수인지 확인 
            else{
                boolean isPalindrome = true;
                // 인덱스를 대칭으로 순회하며 같은지 확인
                for(int i=0;i<inputNumber.length();i++){
                    // 하나라도 다르면 팰린드롬 수가 아니므로 false로 바꿔준다.
                    if(inputNumber.charAt(i)!=inputNumber.charAt(inputNumber.length()-1-i)){
                        isPalindrome = false;
                    }
                }

                if(isPalindrome){
                    bw.write("yes\n");
                }
                else{
                    bw.write("no\n");
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}