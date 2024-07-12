import java.io.*;
public class _23304 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if(isAkarakaPalindrome(input)){
            System.out.println("AKARAKA");
        }
        else{
            System.out.println("IPSELENTI");
        }   
    }

    // 재귀적으로 아카라카 팰린드롬인지 확인하는 함수
    static public boolean isAkarakaPalindrome(String input){
        int len = input.length();

        if (len==1){
            return true;
        }

        boolean result = false;

        if (len>=2){
            // 접두사 접미사 분리 
            String prefix = input.substring(0, len/2);
            String suffix = input.substring(len/2+(len%2==0 ? 0 : 1), len); // 짝수 홀수에 따라 다르게 처리

            // input이 팰린드롬인지 확인
            for(int i=0;i<len/2;i++){
                if(input.charAt(i)!=input.charAt(len-1-i)){
                    return false;
                }
            }

            // input의 접두사 접미사도 아카라카 팰린드롬이면 true
            if(isAkarakaPalindrome(prefix) && isAkarakaPalindrome(suffix) ){
                result = true;
            }
        }

        return result;
    }
}