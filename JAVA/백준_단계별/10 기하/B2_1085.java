import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2_1085 {
    public static void main(String[] args) throws IOException {
        // 4개의 좌표 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // 사각형 최소 거리 구하기
        // 0 0 w h
        // x y
        int d1 = Math.abs(w-x);
        int d2 = Math.abs(h-y);

        List<Integer> distances = new ArrayList<Integer>();
        distances.add(x);
        distances.add(y);
        distances.add(d1);
        distances.add(d2);

        System.out.println(distances
                .stream()
                .min(Integer::compareTo)
                .orElseThrow()
        );
    }
}