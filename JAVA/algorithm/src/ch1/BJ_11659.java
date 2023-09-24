package ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class BJ_11659 {
    public static void main(String[] args) throws IOException {
        // N: 수의 갯수, M: 합을 구해야 하는 횟수
        // N, M을 입력받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);

        // N개의 수를 입력받는다
        List<String> input2 = List.of(br.readLine().split(" "));
        List<Integer> numList = input2.stream().map(Integer::parseInt).collect(Collectors.toList());

        // 구간합 구하기
        // s[i] = S[i-1] + A[i]
        for(int i=1;i<N;i++){
            numList.set(i,numList.get(i-1)+numList.get(i));
        }
        numList.add(0,0); // 1번째 숫자가 인덱스 1이 되도록함.

        // 구간 i,j를 M번 입력받고 구간합을 출력한다
        // S[i~j] = S[j] - S[i-1]
        for(int i=0;i<M;i++){
            String[] input3 = br.readLine().split(" ");
            int I = Integer.parseInt(input3[0]);
            int J = Integer.parseInt(input3[1]);
            System.out.println(numList.get(J)-numList.get(I-1));
        }
    }
}
