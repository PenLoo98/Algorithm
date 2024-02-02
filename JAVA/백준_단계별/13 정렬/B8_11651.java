import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B8_11651 {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // x좌표가 증가하는 순으로
        // x좌표가 같으면 y좌표가 증가하는 순서로 정렬

        int[][] inputs = new int[N][2];

        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            inputs[i][0] = Integer.parseInt(input[0]);
            inputs[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(inputs, (a, b) -> {
            if(a[1]==b[1]){
                return Integer.compare(a[0], b[0]);
            }
            else{
                return Integer.compare(a[1], b[1]);
            }
        });

        for(int i=0;i<N;i++){
            sb.append(inputs[i][0]+" "+inputs[i][1]+"\n");
        }
        System.out.println(sb);
    }
}