import java.util.*;
import java.io.*;
public class _1654 {
    static int k; // 이미 가지고 있는 랜선의 개수
    static int n; // 필요한 랜선의 개수
    static int[] lans; // 이미 가진 랜선의 길이를 저장한 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        lans = new int[k];

        int maxLen=0;
        for(int i=0;i<k;i++){
            lans[i]=Integer.parseInt(br.readLine());
            if(lans[i]>maxLen){
                maxLen=lans[i];
            }
        }
        long left = 1;
        long right = maxLen;
        long answer=0; // 랜선의 최대 길이
        long mid=0;
        while(left<=right){
            mid=(left+right)/2;
            // 자른 개수가 N보다 많으면 단위를 더 길게 잘라도 된다.
            if(getCutLines(mid)>=n){
                answer = mid;
                left = mid+1;
            }
            // 자른 개수가 N보다 적으면 단위를 더 짧게 잘라도 된다.
            else{
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
    // unit 단위로 잘랐을 때 나오는 랜선의 개수를 구하는 함수
    static int getCutLines(long unit){
        int cutLines = 0;
        for(int i=0;i<k;i++){
            cutLines += lans[i]/unit;
        }
        return cutLines;
    }
}