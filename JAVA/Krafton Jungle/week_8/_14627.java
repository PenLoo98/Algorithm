import java.util.*;
import java.io.*;

public class _14627 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken()); // 사온 파의 개수
        int c = Integer.parseInt(st.nextToken()); // 주문받은 파닭 수

        int[] arr = new int[s];
        long sumLength = 0;
        for(int i=0; i<s; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sumLength += arr[i];
        }
        Arrays.sort(arr); // 내림차순 정렬

        // 자르고자 하는 파의 길이를 middle로 설정
        long left = 1;
        long right = arr[s-1];
        long answer = 0;
        
        // 길이가 middle일 때 자를 수 있는 파의 개수를 구함
        while(left<=right){
            long middle = (left+right)/2;
            if(get_piece(arr, middle)>=c){
                answer = middle;
                left = middle+1;
            }else{
                right = middle-1;
            }
        }

        System.out.println(sumLength - answer*c);   
    }

    static long get_piece(int[] arr, long middle){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            count += arr[i]/middle;
        }
        return count;
    }
}