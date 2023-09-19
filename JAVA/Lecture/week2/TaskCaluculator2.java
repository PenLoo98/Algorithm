package lecture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TaskCaluculator2 {
    public static void main(String[] args) {
        // 분량의 중앙값을 기준으로
        int totalAmount = 301; // 끝나는 분량
        int achivedAmount = 1; // 시작 지점 (처음이면 0)
        int dailyAmount = 10;
        int increaseAmount = 2;

        // 전체분량 짝수,홀수 처리
        int firstHalfAmount = totalAmount/2; // 150
        int secondHalfAmount = totalAmount/2; // 150
        if(totalAmount%2 != 0){
            firstHalfAmount += 1; // 151
        }

        int firstPartDays = calculateDays(firstHalfAmount,achivedAmount,dailyAmount,increaseAmount);
        int secondPartDays = calculateDays(secondHalfAmount,achivedAmount,dailyAmount,increaseAmount);
        // 9, 9

        List<Integer> firstAmountList = dailyAmountList(firstPartDays,firstHalfAmount,dailyAmount,increaseAmount);
        // [10, 12, 14, 16, 18, 20, 22, 24, 15] 합:151

        List<Integer> secondAmountList = dailyAmountList(secondPartDays,secondHalfAmount,dailyAmount,increaseAmount);
        Collections.reverse(secondAmountList);
        // [14, 24, 22, 20, 18, 16, 14, 12, 10] 합:150

        // 뒤집은 리스트를 합친 리스트 생성
        // TODO: 첫파트 마지막 + 2번째파트 처음의 합이 마지막전 분량보다 작은경우 합치기
        List<Integer> totalAmountList = new ArrayList<>(firstAmountList);
        // [10, 12, 14, 16, 18, 20, 22, 24, 15]

        int FirstPartLastOne = firstAmountList.get(firstAmountList.size()-1);
        int SecondPartFirstOne = secondAmountList.get(0);
        int FirstPartLastTwo = firstAmountList.get(firstAmountList.size()-2);

        if(FirstPartLastOne+SecondPartFirstOne <= FirstPartLastTwo){
            totalAmountList.add(FirstPartLastOne+SecondPartFirstOne);
            totalAmountList.remove(totalAmountList.size()-2);
            secondAmountList.remove(0);
        }
        totalAmountList.addAll(secondAmountList);
        System.out.println(totalAmountList);
        // [10, 12, 14, 16, 18, 20, 22, 24, 15, 14, 24, 22, 20, 18, 16, 14, 12, 10]
        System.out.println(stackAmountList(totalAmountList));
    }

    // 총 소요일 계산
    public static int calculateDays(int targetAmount, int achivedAmount, int dailyAmount, int increaseAmount){
        int achived = achivedAmount;
        int spendDay = 0;

        while(achived < targetAmount){
            achived += dailyAmount;
            spendDay++;
            dailyAmount += increaseAmount;
        }
        return spendDay;
    }

    // 일일 분량 계산
    // [10, 12, 14, 16, 18, 20, 22, 24, 26]
    // [10, 12, 14, 16, 18, 20, 22, 24, 15]
    public static List<Integer> dailyAmountList(int days, int totalAmount,int dailyAmount, int increaseAmount){
        List<Integer> dailyAmountList = new ArrayList<>();
        int amount = dailyAmount;
        int stack = 0;
        for(int i=0;i<days;i++){
            stack += amount;
            // 마지막 날 총 분량을 넘기는 경우
            if(stack > totalAmount){
                dailyAmountList.add(amount-(stack-totalAmount));
                break;
            }
            dailyAmountList.add(amount);
            amount += increaseAmount;
        }
        return dailyAmountList;
    }

    // TODO: 마지막 날 목표량 넘어가는 경우 잘라주기 (162 -> 150)
    // [10, 22, 36, 52, 70, 90, 112, 136, 162]
    // 누적 분량 계산
    public static List<Integer> stackAmountList(List<Integer> dailyAmountList){
        List<Integer> stackAmountList = new ArrayList<>();
        int stack = 0;
        for(int i=0;i<dailyAmountList.size();i++){
            stack += dailyAmountList.get(i);
            stackAmountList.add(stack);
        }
        return stackAmountList;

    }
}
