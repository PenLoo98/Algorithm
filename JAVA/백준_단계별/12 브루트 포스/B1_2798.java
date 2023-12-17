import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B1_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> inputs = List.of(br.readLine().split(" "));
        List<Integer> numbers = inputs
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        getMax(M, numbers);
    }

    public static void getMax(int M, List<Integer> numbers){
        List<Integer> combine = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                for (int k = j + 1; k < numbers.size(); k++) {
                    int sum = numbers.get(i) + numbers.get(j) + numbers.get(k);
                    if (sum <= M) {
                        combine.add(sum);
                    }
                }
            }
        }
        combine.sort(Integer::compareTo);
        System.out.println(combine.get(combine.size() - 1));
    }
}