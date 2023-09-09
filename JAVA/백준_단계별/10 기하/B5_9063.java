import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B5_9063 {
    public static void main(String[] args) throws IOException {
        // 데이터 타입: int
        // 자료구조: 리스트 (x좌표, y좌표 각각)
        // x좌표 리스트의 최대값 - 최솟값
        // y좌표 리스트의 최대값 - 최솟값
        // 넓이

        // N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 좌표 입력
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        while(N-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            xs.add(Integer.parseInt(st.nextToken()));
            ys.add(Integer.parseInt(st.nextToken()));
        }

        // 땅 넓이 구하기
        int x_min = xs.stream()
                .min(Integer::compareTo)
                .orElseThrow();
        int x_max = xs.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        int y_min = ys.stream()
                .min(Integer::compareTo)
                .orElseThrow();
        int y_max = ys.stream()
                .max(Integer::compareTo)
                .orElseThrow();

        // 결과 출력
        System.out.println((x_max - x_min)*(y_max - y_min));
    }
}