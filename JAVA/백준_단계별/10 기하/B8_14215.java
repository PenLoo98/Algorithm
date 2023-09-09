import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B8_14215 {
    public static void main(String[] args) throws IOException {
        // 세 변중 가장 긴 변은 나머지 두변의 합보다 작아야한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 세변의 길이를 배열에 넣는다.
        List<Integer> edges = List.of(a,b,c);
        edges = edges.stream().sorted().collect(Collectors.toList());
        int e1 = edges.get(0);
        int e2 = edges.get(1);
        int e3 = edges.get(2);

        // 제일 긴 변이 나머지 두 변의 합보다 작은 경우
        if( (e1+e2) > e3){
            System.out.println(e1+e2+e3);
        }
        // 제일 긴 변이 나머지 두 변의 합보다 크거나 같은 경우
        else {
            // 16 41 64
            int diff = e3-e2-e1; // 7
            System.out.println(e1+e2+e3-1-diff); // 121-1-7=113
        }
    }
}