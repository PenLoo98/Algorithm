import java.util.*;
import java.io.*;
public class _1969 {
    public static void main(String[] args) throws IOException{
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // DNA의 수
        int M = Integer.parseInt(st.nextToken()); // DNA의 길이

        String[] dna = new String[N]; // 길이가 m인 DNA 저장한 배열
        for(int i=0; i<N; i++){
            dna[i] = br.readLine();
        }

        // DNA들의 각 자리의 알파벳 빈도를 계산
        StringBuilder sb = new StringBuilder();
        
        int totalDistance = 0; // 가장 짧은 hamming distance 길이합 
        for(int i=0; i<M; i++){ // i: 현재 확인할 i번째 자리
            int[] alphabetFrequencyCount = new int[26];

            // i번째 자리의 알파벳 빈도를 계산 
            for(int j=0; j<N; j++){ // j: N개의 DNA 중 현재 확인하고 있는 j번째 DNA
                alphabetFrequencyCount[dna[j].charAt(i)-(int)'A']++;
            }

            // i번째 자리에 해당하는 최다 빈도 알파벳들을 리스트로 저장
            // int maxFrequency = Arrays.stream(alphabetFrequencyCount).max().getAsInt();
        
            int maxFrequency = 0; // i번째 자리의 최다 빈도 수 
            for(int frequency: alphabetFrequencyCount){
                if(frequency > maxFrequency){
                    maxFrequency = frequency;
                }
            }

            // 최다 빈도에 해당하는 사전 순으로 가장 빠른 알파벳 sb에 추가
            for(int k=0; k<26; k++){
                if(alphabetFrequencyCount[k] == maxFrequency){
                    sb.append((char)('A'+k));
                    break;
                }
            }
            
            // 빈도 수 계산
            totalDistance+=N-maxFrequency;
        }

        // 사전 순으로 가장 빠른 DNA + 빈도 수 출력
        System.out.println(sb.toString()+"\n"+totalDistance);
    }
}