import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B9_1181 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Short N = Short.parseShort(br.readLine());
        String[] inputs = new String[N];
        for(short i=0;i<N;i++){
            inputs[i] = br.readLine();
        }
        // 중복 제거
        List<String> notDuplicate = new ArrayList<>(N);
        for(String input:inputs){
            if(!notDuplicate.contains(input)){
                notDuplicate.add(input);
            }
        }

        // 문자열 길이순, 사전순 정렬
        Collections.sort(notDuplicate, (a,b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() - b.length();
            }
        });

        for(String word: notDuplicate){
            sb.append(word+"\n");
        }

        System.out.println(sb);
    }
}
