import java.io.*;
import java.util.*;
public class _17128{
    public static void main(String[] args) throws IOException{
        /// 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 소 총 마리수
        int q = Integer.parseInt(st.nextToken()); // 장난칠 횟수
        
        // n마리 소의 품질 점수
        int[] cowsQuality = new int[n]; // 0 ~ n-1
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i <n; i++){
            cowsQuality[i] = Integer.parseInt(st.nextToken());
        }
        
        // 장난칠 Q마리 소의 번호
        int[] kiddingCowNum = new int[q];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < q; i++){
            kiddingCowNum[i] = Integer.parseInt(st.nextToken()) - 1; // 인덱스 보정
        }
        
        /// 계산
        // 원래 소의 품질 합
        int[] originQualityList = new int[n];
        for(int i=0;i<n;i++){
            int partSum = cowsQuality[i]*cowsQuality[(i+1)%n]*cowsQuality[(i+2)%n]*cowsQuality[(i+3)%n];
            originQualityList[i] = partSum;
        }
        // 원래 품질합 계산
        int originSum = 0; 
        for(int quality: originQualityList){
            originSum+=quality;
        }

        // 장난친 소의 품질 합
        for(int i = 0; i < q; i++){
            int start = kiddingCowNum[i];
            cowsQuality[start]*=-1; // 

            // 변화된 총합계산
            for(int j=0;j<4;j++){ // 4번 반복
                originQualityList[start] = cowsQuality[start]
                                    *cowsQuality[(start+1)%n]
                                    *cowsQuality[(start+2)%n]
                                    *cowsQuality[(start+3)%n];

                // "-기존 품질 = 변화된 품질"이므로
				// "-기존 품질 + 변화된 품질"을 해주기 위해서 
                // "+ 2*변화된 품질"을 해줬다. 
                originSum+=2*originQualityList[start];

                // start = (start==0) ? n-1 : start-1;

                // 인덱스 0에서 -1을 해주면 n-1로 바꿔준다.
                if(start==0){
                    start=n-1;
                }
                else{
                    start--;
                }
            }

            sb.append(originSum+"\n");
        }
        System.out.println(sb.toString()); // 결과값 출력
    }
}