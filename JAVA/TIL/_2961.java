import java.io.*;
import java.util.*;

public class _2961 {
    static int minValue=Integer.MAX_VALUE;
    static int[][] ingredients;
    public static void main(String[] args) throws IOException{
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ingredients = new int[n][2];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            ingredients[i][0]=Integer.parseInt(st.nextToken());
            ingredients[i][1]=Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.deepToString(ingredients));

        // 신맛과 쓴맛의 차이의 최소값을 구하기
        calculateTaste(1,0,0,0);

        // 맛 차이의 최소값 출력
        System.out.println(minValue);
    }
    static void calculateTaste(int sourness, int bitterness, int index, int count){
        // 모든 재료를 살펴봤으면
        if(index==ingredients.length){
            // 재료를 1개라도 골랐다면
            if(count>=1){
                minValue=Math.min(minValue, Math.abs(sourness-bitterness));
            }
            return;
        }
        
        // 재료 선택 
        calculateTaste(sourness*ingredients[index][0], bitterness+ingredients[index][1], index+1, count+1);

        // 재료 선택 x
        calculateTaste(sourness, bitterness, index+1, count);
    }
}