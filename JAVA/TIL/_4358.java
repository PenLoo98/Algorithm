import java.util.*;
import java.io.*;

class _4358{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> treeMap = new HashMap<>();
        String input;
        int totalTrees = 0; // 전체 나무 수

        // 1. 입력 -> 더 이상 입력이 되지 않을 때까지만 입력받기 + 전체 나무 수 카운트
        // 2. 문자열 입력 어떻게 저장? 키:값 -> 종:횟수 
        // 3. 해시맵에 글자들 사전 순으로 정렬하기
        // 4. 결과 출력

        while(true){
            input = br.readLine();
            // 더 이상 입력이 없으면 종료
            if(input==null || input.isEmpty()){
                break;
            }
            // 이미 존재하는 키값이면 그냥 +1, 없으면 추가
            treeMap.put(input, treeMap.getOrDefault(input, 0)+1);
            // 전체 나무 수 카운트
            totalTrees++;
        }

        // 해시맵에 글자들 사전 순으로 정렬하기
        List<String> sortedList = new ArrayList<>(treeMap.keySet());
        Collections.sort(sortedList);

        // 나무 종류마다 차지하는 비율 계산하여 버퍼에 저장
        for (String treeKey : sortedList){
            int currentTrees = treeMap.get(treeKey);
            double ratio = (currentTrees/(double)totalTrees)*100;
            bw.write(String.format("%s %.4f%n", treeKey, ratio));
        }

        // 버퍼에 저장된 내용 출력
        bw.flush();
        bw.close();
    }
}