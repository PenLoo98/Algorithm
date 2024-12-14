import java.util.*;
import java.io.*;

public class _4659_2 {
    static StringBuilder sb = new StringBuilder();
    static Set<Character> vowels;
    static Set<Character> consonants;
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        consonants = new HashSet<>(Arrays.asList('b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'));

        while(true){
            String input = br.readLine();
            
            if(input.equals("end")){
                break;
            }
            
            checkPronuciation(input);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void checkPronuciation(String input)throws IOException{
        // 순회하며 확인
        boolean hasVowel = false; // 모음이 하나 이상 있는지 확인
        int consecutiveVowels = 0;
        int consecutiveConsonants = 0;
        char beforeChar = '#'; // 이전 문자 저장
        
        for(int i=0;i<input.length();i++){
            char currentChar = input.charAt(i);

            // 모음, 자음 있는지 확인
            if(vowels.contains(currentChar)){
                hasVowel=true;
                consecutiveVowels++; 
                consecutiveConsonants=0;       
            }
            else{
                consecutiveConsonants++;
                consecutiveVowels=0; 
            }

            // 모음, 자음 연속인지 확인
            if(consecutiveVowels>=3 || consecutiveConsonants>=3){
                sb.append(String.format("<%s> is not acceptable.", input));
                return;
            } 
            
            // 같은 글자가 연속적으로 2번 오면 안 된다. ee,oo는 허용
            if(currentChar!='e' && currentChar!='o' && currentChar==beforeChar){
                sb.append(String.format("<%s> is not acceptable.", input));
                return;
            }

            beforeChar=currentChar;
        }
        if(hasVowel==false){
            sb.append(String.format("<%s> is not acceptable.", input));
        }
        else{
            sb.append(String.format("<%s> is acceptable.", input));
        }

        return;
    }
}