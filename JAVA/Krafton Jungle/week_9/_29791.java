import java.util.*;
import java.io.*;
public class _29791 {
    public static void main(String[] args)throws IOException{
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> erda = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            erda.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(erda); // 오름차순 정렬

        ArrayList<Integer> origin = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            origin.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(origin); // 오름차순 정렬

        // 2. 사용횟수 계산
        int whenUseErda = 0; // erda 스킬 사용시간
        int howManyErda = 0; // erda 스킬 사용횟수

        int whenUseOrigin = 0; // origin 스킬 사용시간
        int howManyOrigin = 0; // origin 스킬 사용횟수
        
        for(int i=0;i<erda.size();i++){
            int curErda = erda.get(i);
            if (curErda >= whenUseErda){
                whenUseErda = curErda + 100; // 스킬 100초마다 사용가능
                howManyErda++;
            }
        }

        for(int i=0;i<origin.size();i++){
            int curOrigin = origin.get(i);
            if (curOrigin >= whenUseOrigin){
                whenUseOrigin = curOrigin + 360; // 스킬 360초마다 사용가능
                howManyOrigin++;
            }
        }

        // 3. 출력
        System.out.println(howManyErda+" "+howManyOrigin);
    }
}