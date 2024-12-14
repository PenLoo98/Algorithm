import java.util.*;
import java.io.*;

public class _1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashMap<Character, Integer> alphabetCount = new HashMap<>();

        // a부터 z까지 카운트 -> 아스키 코드에 따라서 
        for(char c = 'a'; c<='z'; c++){
            alphabetCount.put(c,0);
        }
        for(char c = 'A'; c<='Z'; c++){
            alphabetCount.put(c,0);
        }
        
        for(int i=0;i<input.length();i++){
            // 알파벳이 아니면 다음으로 넘김
            if(!Character.isAlphabetic(input.charAt(i))){
                continue;
            }
            // 대문자로 변경
            char upperC = Character.toUpperCase(input.charAt(i));
            // 알파벳 대문자 키에 +1
            alphabetCount.put(upperC, alphabetCount.get(upperC)+1);
        }

        // 최다빈도 알파벳 찾기 
        int maxCount = Collections.max(alphabetCount.values());
        ArrayList<Character> maxChar = new ArrayList<>();
        // 최다빈도에 해당하는 알파벳만 maxChar에 추가
        for(char key: alphabetCount.keySet()){
            if(alphabetCount.get(key)==maxCount){
                maxChar.add(key);
            }
        }
        if(maxChar.size()>1){
            System.out.println("?");
            return;
        }
        else{
            System.out.println(maxChar.get(0));
        }
    }
}