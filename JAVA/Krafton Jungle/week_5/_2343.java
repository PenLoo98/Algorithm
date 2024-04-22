import java.io.*;
import java.util.*;

public class _2343 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n,m 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 강의 입력
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr 최대값 maxLecture와 모든 강의 합 lectureSum 구하기 
        int longestLecture=arr[0];
        int lectureSum=arr[0];
        for(int i=1;i<arr.length;i++){
            lectureSum+=arr[i];
            if(arr[i]> longestLecture){
                longestLecture=arr[i];
            }
        }

        int start = longestLecture;
        int end = lectureSum;
        
        // 매개 변수 탐색
        while(start<=end){
            int mid = (start+end)/2;
            int sum = 0;
            int count = 1;
            // 블루레이 크기가 mid일 때 몇개가 담기는지 확인한다.
            for(int i=0;i<arr.length;i++){
                // 담을 수 있으면 담자
                if(sum+arr[i] <= mid){
                    sum+=arr[i];
                }
                // 담을 수 없으면 다음 블루레이에 담자
                else if(sum+arr[i] > mid){
                    count++;
                    sum=arr[i];
                }
            }
            // mid일 때 담기는 갯수 count를 m과 비교한다.
            if (count > m){
                start=mid+1;
            }
            // mid가 조건을 만족하더라도 더 작은 값도 되는지 확인한다.
            else if (count <= m){
                end=mid-1;
            }
        }
        System.out.println(start);
    }
}
