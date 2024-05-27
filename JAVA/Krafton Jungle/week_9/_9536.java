import java.util.*;
import java.io.*;

public class _9536 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            // 녹음된 소리 
            String[] sounds = br.readLine().split(" ");

            // 동물 울음 소리 
            ArrayList<String> crying = new ArrayList<>();
            while(true){
                String[] animal = br.readLine().split(" ");
                // 마무리 질문인가?
                if(animal[0].equals("what") && animal[1].equals("does") && animal[2].equals("the")){
                    break;
                }

                // 동물 울음소리면 추가 
                crying.add(animal[2]);
            }

            // 여우 울음소리 가려내기 
            for(String sound: sounds){
                if(!crying.contains(sound)){
                    System.out.printf(sound+" ");
                }
            }
        }
    }
}
