package lecture;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// TODO
// 분량 범위 마지막 날 최대한도 넘기지 않는 기능

public class TaskCalculator {
    public static void main(String[] args) throws Exception {
        int totalAmount = 379; // 끝나는 분량
        int achivedAmount = 39; // 시작 지점
        int dailyAmount = 10;
        int increaseAmount = 2;

        int spendDay = calculateDays(totalAmount,achivedAmount,dailyAmount,increaseAmount);
        List<LocalDate> dateList = localDateList(spendDay);
        List<String> amountList = calculateStackAmount(spendDay,totalAmount,achivedAmount,dailyAmount,increaseAmount);
        System.out.println(CalandarTaskText("개발자 온보딩",dateList,amountList));
    }
    
    // 매일 조금씩 증가하는 목표를 설정 후 총 몇일이 걸리는 지 계산
    // 총 분량, 시작 분량, 분량 증가량
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

    // 오늘부터 n일까지의 날짜 계산하여 리스트로 반환
    public static List<LocalDate> localDateList(int days){
        // 오늘 날짜
        List<LocalDate> dateList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for(int i=0;i<days;i++){
            dateList.add(today.plusDays(i));
        }
        return dateList;
    }

    // 오늘부터 n일까지 분량의 범위 리스트
    public static List<String> calculateStackAmount(int totalDays,int totalAmount,int achivedAmount,int dailyAmount, int increaseAmout){
        // (옵션)마지막 날은 총 분량을 넘기는 경우 따로 처리
        List<String> amountList = new ArrayList<>();
        int stack = achivedAmount; // 시작 분량
        int amount = dailyAmount;
        for(int i=0;i<totalDays;i++){
            // 마지막 날 총 분량을 넘기는 경우
            if((stack+amount) > totalAmount){
                amountList.add(stack + "~" + totalAmount + " (" + (totalAmount - stack) + ")");
            }
            else{
                amountList.add(stack + "~" + (stack+amount) + " (" + amount + ")");
            }
            stack += amount;
            amount += increaseAmout;
        }
        return amountList;
    }

    // 날짜 + 주제 + 분량 합치기
    public static String CalandarTaskText(String taskname, List<LocalDate> dateList, List<String> amountList) throws Exception {
        // 입력 오류시 예외처리
        if(dateList.size() != amountList.size()){
            throw new IOException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 문자열로 합쳐서 리스트에 저장
        for(int i=0;i<dateList.size();i++){
            String input = dateList.get(i) +" "+ taskname +" "+ amountList.get(i)+"\n";
            stringBuilder.append(input);
        }
        String TaskCalandarText = stringBuilder.toString();
        return TaskCalandarText;
    }
}
