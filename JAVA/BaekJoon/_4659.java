import java.io.*;

public class _4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String input = br.readLine();
            if(input.equals("end")){
                break;
            }

            int vowelCount = 0;
            int consonantCount = 0;
            boolean isVowel = false; // 모음이 있는지 확인
            boolean isAcceptable = true; // acceptable이라고 가정하고 시작

            // 모음 하나 반드시 포함 
            // 모음,자음 3연속 불가 
            // 같은 글자가 연속으로 오면 안됨, ee, oo 제외

            char c;
            for(int i=0; i<input.length(); i++){
                c = input.charAt(i);
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    isVowel = true;
                    vowelCount++;
                    consonantCount = 0;
                }else{
                    vowelCount = 0;
                    consonantCount++;
                }

                // 같은 글자가 연속으로 오는지 확인 (ee, oo 제외)
                if(i>=1){
                    if(input.charAt(i-1)==input.charAt(i) && input.charAt(i)!='e' && input.charAt(i)!='o'){
                        isAcceptable = false;
                    }
                }

                // 모음, 자음 3연속 확인
                if(vowelCount>=3 || consonantCount>=3){
                    isAcceptable = false;
                }
            }

            // 모음이 하나도 없으면 안됨
            if(!isVowel){
                isAcceptable = false;
            }

            // 결과 버퍼에 저장
            if(isAcceptable){
                bw.write("<"+input+"> is acceptable.\n");
            }else{
                bw.write("<"+input+"> is not acceptable.\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}