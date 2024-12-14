import java.util.*;
import java.io.*;
public class _5568 {
    static int n;
    static int k;
    static HashMap<String,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // n개의 카드
        k = Integer.parseInt(br.readLine()); // k장을 선택해 숫자 조합
        String[] cards = new String[n];
        boolean[] selectList = new boolean[n]; // 선택한 카드 목록

        for(int i=0; i<n; i++){
            cards[i]=br.readLine();
        }

        // n개 카드 중에 k개를 선택해서 만들 수 있는 모든 숫자 생성 
        selectCardtoNumber(cards, selectList, 0, new StringBuilder());
        
        // 만들 수 있는 정수 개수 출력 
        System.out.println(map.size());
    }

    static void selectCardtoNumber(String[] cards, boolean[] selectList, int selectCount, StringBuilder sb){
        // 종료 조건 
        // k장 골랐으면 해시맵에 저장하고 종료
        if(selectCount==k){
            map.put(sb.toString(), 1); // 해시맵이라 key가 중복없이 들어가는게 중요, value는 의미없음.
            return ;
        }

        // 탐색 조건 
        for(int i=0; i<n; i++){
            if(selectList[i]==false){ // 선택하지 않은 카드 중에서 선택
                sb.append(cards[i]);
                selectList[i]=true;
                
                selectCardtoNumber(cards, selectList, selectCount+1, sb);

                sb.delete(sb.length()-cards[i].length(), sb.length()); // 원래 문자열로 복구
                selectList[i]=false;
            }
        }
    }
}