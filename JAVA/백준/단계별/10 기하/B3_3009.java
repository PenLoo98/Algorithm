import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_3009 {
    public static void main(String[] args) throws IOException {
        // 세점을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int x1 = Integer.parseInt(st1.nextToken());
        int y1 = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int x2 = Integer.parseInt(st2.nextToken());
        int y2 = Integer.parseInt(st2.nextToken());

        StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        int x3 = Integer.parseInt(st3.nextToken());
        int y3 = Integer.parseInt(st3.nextToken());

        // 4번째 점 구하기
        // x, y 각각 갯수가 1개 적은 좌표를 출력하면 되는듯?
        int x4 = 0;
        if(x1==x2){
            x4 = x3;
        } else if (x1 == x3) {
            x4 = x2;
        } else if (x2 == x3) {
            x4 = x1;
        }

        int y4 = 0;
        if(y1==y2){
            y4 = y3;
        } else if (y1 == y3) {
            y4 = y2;
        } else if (y2 == y3) {
            y4 = y1;
        }

        // 4번째 점 출력
        System.out.printf("%d %d",x4,y4);
    }
}