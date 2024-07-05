import java.io.*;
class _11727{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int prevN = 1; // n까지의 
        int cases = 1; // 경우의 수

        // f(n): n일 때 가능한 경우의 수 
        // n 홀수: 2f(n-1)-1
        // n 짝수: 2f(n-1)+1

        while(prevN<n){
            // prev 홀수면 +1
            if(prevN%2==1){
                cases=(2*cases+1)%10007;
            }
            // prev 짝수면 -1
            else if(prevN%2==0){
                cases=(2*cases-1)%10007;
            }
            prevN++;
        }
        System.out.println(cases);
    }
}