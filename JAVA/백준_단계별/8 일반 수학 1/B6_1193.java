import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B6_1193 {
    public static void main(String[] args) throws IOException {
        // X 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1: 1/1
        // 2: 1/2 => 0/+1
        // 3: 2/1 => +1/-1
        // 4: 3/1 => +1/0
        // 5: 2/2 => -1/+1
        // 6: 1/3 => -1/+1
        // 7: 1/4 => 0/+1
        // 8: 2/3 => +1/-1
        // 9: 3/2 => +1/-1
        // 10: 4/1 => +1/-1
        // 11: 5/1 => +1/0
        // 12: 4/2 => -1/+1
        // 13: 3/3 => -1/+1
        // 14: 2/4 => -1/+1
        // 15: 1/5 => -1/+1
        // 16: 1/6 => 0/+1

        // 합 2: 1
        // 합 3: 2 3 => +/-
        // 합 4: 4 5 6 => -/+
        // 합 5: 7 8 9 10 => +/-
        // 합 6: 11 12 13 14 15 => -/+
    }
}