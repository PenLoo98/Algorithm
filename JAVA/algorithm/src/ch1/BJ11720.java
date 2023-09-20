package ch1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BJ11720 {
    public static void main(String[] args) {
        // 숫자 입력
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        // TODO: java.util.InputMismatchException: For input string: "7000000000000000000000000"
        // 숫자의 합
        long input = sc.nextLong();
        List<String> inputString = List.of(Long.toString(input).split(""));
        List<Long> numsList = inputString.stream().map(Long::parseLong).toList();
        int sum = 0;
        for(long num: numsList){
            sum += num;
        }
        // 숫자의 합 출력
        System.out.println(sum);
    }
}
