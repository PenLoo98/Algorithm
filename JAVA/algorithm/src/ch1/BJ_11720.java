package ch1;

import java.util.Scanner;

public class BJ_11720 {
    public static void main(String[] args) {
        // 숫자 입력
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

//        // 공백없이 숫자 입력: 방법 1 List<String>
//        String input = sc.next();
//        List<String> inputString = List.of(input.split(""));
//        List<Long> numsList = inputString.stream().map(Long::parseLong).collect(Collectors.toList());
//
//        long sum = 0;
//        for(long num: numsList){
//            sum += num;
//        }

        // 공백없이 숫자 입력: 방법 2 List<char>
        String input = sc.next();
        char[] inputChar = input.toCharArray();
        long sum = 0;
        for(char num: inputChar){
            sum += num - '0'; // -'0'으로 실제 숫자값을 구한다.
        }

        // 숫자의 합 출력
        System.out.println(sum);
    }
}
