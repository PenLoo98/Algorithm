import java.io.*;
import java.util.*;

public class _20115 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Integer.parseInt(br.readLine());
        double sumDrink = 0, maxDrink = 0, currentDrink = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            currentDrink = (double)Integer.parseInt(st.nextToken());
            if( maxDrink < currentDrink){
                maxDrink = currentDrink;
            }
            sumDrink += currentDrink;
        }
        // 모든 에너지드링크 양을 더하고 최대양인 드링크를 한번 더 더해주고 전체 나누기 2하면 
        // 최대양 드링크는 1병만큼, 나머지 드링크는 절반만큼 들어있는 총량을 구할 수 있다.
        System.out.println((sumDrink+maxDrink)/2);
    }
}