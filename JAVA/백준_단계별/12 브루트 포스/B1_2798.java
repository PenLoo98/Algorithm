import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B1_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 카드 수 입력
        List<String> inputs = List.of(br.readLine().split(" "));
        List<Integer> numbers = inputs
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if(numbers.size() != N){
            throw new IOException();
        };

        // N개의 카드 중 3개 합이 M과 가장 가까운 수 출력

        // 카드의 합이 M보다 작거나 같으면서 가장 가까운 수 출력
    }

//    public static List<Integer> sumCombination(int n, List<Integer> numbers){
//        // 기존 Int List를 가져온다
//        // 합을 저장할 새로운 List를 만든다.
//        // 숫자 3개를 가져와서 합을 구한다. or 조합의 인덱스를 경우의 수를 구한다
//        // 새로 만든 3개의 숫자합 리스트에 값이 없으면 추가한다.
//        return;
//    }
}