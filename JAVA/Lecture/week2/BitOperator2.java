package lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BitOperator2 {
    public static void main(String[] args) {
        // 정수 입력
        Scanner sc = new Scanner(System.in);
        System.out.println("세탁기 초기상태 Byte를 입력하세요(0~127):");
        int status = sc.nextInt();

        // 입력한 정수 -> byte형태로 변환
        String binaryString = Integer.toBinaryString(status);
        System.out.println("세탁기 입력상태="+binaryString);

        // shift 연산자(>>>)와 AND 1로 각 비트가 1인지 확인
        List<Boolean> lists = new ArrayList<Boolean>();

        for(int i=0; i<8; i++){
            boolean isOne = ((status>>>i) & 1) != 0;
            // 비교결과를 리스트에 저장
            lists.add(i,isOne);
        }

        // 확인한 결과를 출력
        System.out.println("전기가 연결되었는지="+lists.get(0));
        System.out.println("수도가 연결되었는지="+lists.get(1));
        System.out.println("문이 닫혀 있는지="+lists.get(2));
        System.out.println("빨래가 들어있는지="+lists.get(3));
        System.out.println("빨래가 너무 많이 들어있지 않은 지="+lists.get(4));
        System.out.println("배수관이 막혀 있지 않은 지="+lists.get(5));
        System.out.println("빨래가 한쪽에 치우쳐 있지 않은 지="+lists.get(6));
    }
}