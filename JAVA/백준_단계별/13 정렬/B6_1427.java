import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B6_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNum = br.readLine().split("");
        Arrays.sort(inputNum, Collections.reverseOrder());
        for (String s : inputNum) {
            System.out.print(s);
        }
    }
}
