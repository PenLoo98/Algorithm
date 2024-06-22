import java.util.*;
import java.io.*;
public class _1911 {
    // 물 웅덩이를 받을 객체
    static class Water{
        int start;
        int end;
        Water(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n: 웅덩이 수
        int l = Integer.parseInt(st.nextToken()); // l: 널판지 길이

        int lastWater = 0; // 물 웅덩이 중 가장 먼 좌표
        ArrayList<Water> waterInputList = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 웅덩이 시작 좌표
            int end = Integer.parseInt(st.nextToken()); // 웅덩이 끝 좌표
            // 가장 멀리있는 웅덩이 좌표 구하기
            if(end>lastWater){
                lastWater=end;
            }
            waterInputList.add(new Water(start, end)); // 리스트에 웅덩이 정보 저장
        }

        // 시작 좌표 -> 끝 좌표 순서로 오름차순으로 정렬
        Collections.sort(waterInputList, new Comparator<Water>(){
            @Override
            public int compare(Water o1, Water o2) {
                if(o1.start==o2.start)
                    return o1.end-o2.end;
                else
                    return o1.start-o2.start;
            }
        });
        
        int covers = 0; // 커버된 널판지 수
        int coversIndex = -1; // 커버된 널판지 인덱스
        
        // 입력된 모든 웅덩이를 기준으로 정렬
        for(Water water : waterInputList){
            // 이미 웅덩이가 덮인 경우 다음 웅덩이로 넘어간다
            if(coversIndex > water.end){
                continue;
            }     
            // 웅덩이 시작점이 커버되지 않은 경우
            if(coversIndex<water.start){
                coversIndex = water.start;
            }
            int remain = (water.end - coversIndex)%l; // 끝좌표까지 덮기위해 추가로 덮이는 부분
            // 나머지가 0이면 그대로 
            if(remain==0){
                covers += (water.end - coversIndex)/l;
                coversIndex = water.end;
            }
            // 나머지가 0이 아니면 몫+1로 
            else if(remain != 0){
                int plus = (water.end - coversIndex)/l + 1; // 설치한 널판지 개수
                covers += plus;
                coversIndex += l * plus;
            }
        }
        
        System.out.println(covers); // 결과 출력
    }   
}