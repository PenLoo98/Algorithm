package lecture;

import java.util.ArrayList;
import java.util.List;

public class TaskCaluculator2 {
    public static void main(String[] args) {
        // 분량의 중앙값을 기준으로
        int totalAmount = 300; // 끝나는 분량
        int achivedAmount = 1; // 시작 지점
        int dailyAmount = 10;
        int increaseAmount = 2;

        // TODO: totalAmount가 짝수, 홀수인 경우 각각처리
        int halfAmount = totalAmount/2;
        int halfSpendDay = calculateDays(halfAmount,achivedAmount,dailyAmount,increaseAmount);
//        System.out.println(halfSpendDay);

        List<Integer> halfAmountList = dailyAmountList(halfSpendDay,dailyAmount,increaseAmount);
        System.out.println(halfAmountList);

        List<Integer> stackAmountList= stackAmountList(halfSpendDay,dailyAmount,increaseAmount);
        System.out.println(stackAmountList);

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
//        System.out.printf("총 소요시간은 %d일입니다.\n",spendDay);
        return spendDay;
    }

    // TODO: 마지막 날 목표량 넘어가는 경우 잘라주기 (26->12)
    // [10, 12, 14, 16, 18, 20, 22, 24, 26]
    // 일일 분량 계산
    public static List<Integer> dailyAmountList(int halfDays, int dailyAmount, int increaseAmount){
        List<Integer> dailyAmountList = new ArrayList<>();
        int amount = dailyAmount;
        for(int i=0;i<halfDays;i++){
            dailyAmountList.add(amount);
            amount += increaseAmount;
        }
        return dailyAmountList;
    }

    // TODO: 마지막 날 목표량 넘어가는 경우 잘라주기 (162 -> 150)
    // [10, 22, 36, 52, 70, 90, 112, 136, 162]
    // 누적 분량 계산
    public static List<Integer> stackAmountList(int halfDays, int dailyAmount, int increaseAmount){
        List<Integer> dailyAmountList = new ArrayList<>();
        int amount = dailyAmount;
        int stack = 0;
        for(int i=0;i<halfDays;i++){
            stack += amount;
            dailyAmountList.add(stack);
            amount += increaseAmount;
        }
        return dailyAmountList;
    }

    // TODO: 목표량 넘어가는 경우 잘라준 분량리스트를 뒤집어서 합치기
    // TODO: 절반 분량리스트를 뒤집어서 붙여주면 될듯

}
