import java.io.*;
import java.util.*;

public class _2811 {
    public static void main(String[] args) throws IOException{
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int emotion = 0; // 오늘 기분
        int sadCount = 0;

        int[] sadDays = new int[n]; // 각 날짜별로 연속된 우울한 날의 수를 저장하는 배열
        // 연속된 우울한 날의 계산해서 sadDays 배열에 저장한다.
        for(int i=0;i<n;i++){
            emotion = Integer.parseInt(st.nextToken());
            // 0은 우울한 날이 아니기 때문에 기분 좋은 날로 간주한다.
            if(emotion >= 0){ 
                sadCount = 0;
                sadDays[i] = sadCount;
            }
            else{
                sadCount++;
                sadDays[i] = sadCount;
            }
        }

        // 우울한 기간이 T라면 우울한 기간이 시작 전날~2T일까지 꽃을 준다.
        boolean[] isGiveFlower = new boolean[n]; // 각 날짜별로 꽃을 주었는지 확인하는 배열
        int needFlower = 0; // 필요한 꽃의 수
        int longestSad = 0; // 최장 우울기간
        // 뒤에서부터 우울한 날을 찾아 2T일 전까지 꽃을 준다.
        for(int i=n-1;i>=0;i--){
            // 최장 우울기간 찾기
            if(sadDays[i] > longestSad){
                longestSad = sadDays[i];
            }

            // 우울한 날의 수가 0이 아니라면 2T일까지 꽃을 준다.
            if(sadDays[i]>0){
                for(int j=i-sadDays[i];j>=i-3*sadDays[i]+1;j--){
                    if(j<0) break;

                    if(isGiveFlower[j] == false){
                        isGiveFlower[j] = true;
                        needFlower += 1;
                    }
                }
                i -= sadDays[i];
            }
        }

        // 최장 우울기간에 추가로 줘야하는 꽃의 수를 찾는다. 
        // 최장 우울기간이 여러개라면 추가로 줘야하는 꽃의 수가 가장 많은 것을 선택한다.
        int plusGive = 0; // 최장길이일 때 추가로 줘야하는 꽃의 수
        for(int i=n-1;i>=0;i--){
            if(sadDays[i] == longestSad){
                int count = 0;
                // 2T+1~3T까지의 false의 갯수를 센다.
                for(int j=i-3*longestSad;j>=i-4*longestSad+1;j--){
                    if(j<0) break;
                    if(isGiveFlower[j] == false){
                        count += 1;
                    }
                }
                // 최장 우울기간일 때 추가로 주는 꽃의 수의 갱신하며 최대값을 찾는다.
                if(count > plusGive){
                    plusGive = count;
                }
            }
        }
        System.out.println(needFlower+plusGive);
    }
}