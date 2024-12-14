import java.util.*;
import java.io.*;

public class _9251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int firstLength = first.length();
        int secondLength = second.length();
        int[][] lcs = new int[firstLength+1][secondLength+1];

        // ACAYKP
        // CAPCAK
        // ACAK가 부분 수열 중 가장 긴 수열

        // 
        for(int i=1;i<firstLength+1;i++){
            for(int j=1;i<secondLength+1;j++){
                // 두 문자가 같으면
                if(first.charAt(i-1)==second.charAt(j-1)){
                    lcs[i][j]=lcs[i-1][j-1]+1;
                }
                // 두 문자가 다르면
                else{
                    lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        System.out.println(lcs[firstLength][secondLength]);
    }    
}
