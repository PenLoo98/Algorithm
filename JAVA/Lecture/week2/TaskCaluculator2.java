package lecture;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TaskCaluculator2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("총 분량: ");
        int totalAmount = Integer.parseInt(sc.nextLine());
        System.out.print("시작 지점: ");
        int achivedAmount = Integer.parseInt(sc.nextLine());
        System.out.print("일일 분량: ");
        int dailyAmount = Integer.parseInt(sc.nextLine());
        System.out.print("일일 분량 증가량: ");
        int increaseAmount = Integer.parseInt(sc.nextLine());
        System.out.print("시작일->오늘부터 n일 전: ");
        int beforeDays = Integer.parseInt(sc.nextLine());
        System.out.print("주제: ");
        String taskName = sc.nextLine();


        // 초기수행 분량 계산
        totalAmount -= achivedAmount;

        // 전체분량 짝수,홀수 처리
        int firstHalfAmount = totalAmount/2; // 150
        int secondHalfAmount = totalAmount/2; // 150
        if(totalAmount%2 != 0){
            firstHalfAmount += 1; // 151
        }

        // 1번째 파트 소요일+분량 계산
        int firstPartDays = calculateDays(firstHalfAmount,dailyAmount,increaseAmount);
        List<Integer> firstAmountList = dailyAmountList(firstPartDays,firstHalfAmount,dailyAmount,increaseAmount);
        // 2번째 파트 소요일+분량 계산
        int secondPartDays = calculateDays(secondHalfAmount,dailyAmount,increaseAmount);
        List<Integer> secondAmountList = dailyAmountList(secondPartDays,secondHalfAmount,dailyAmount,increaseAmount);

        // 1번째 파트 + 2번째 파트 합치기
        List<Integer> totalAmountList = sumAmountList(firstAmountList,secondAmountList);

        // 합친 리스트로 누적 범위 분량 리스트 생성
        List<String> stackAmountRangeList =stackAmountRangeList(totalAmountList,achivedAmount);

        // 소요일 날짜 리스트 생성
        List<LocalDate> dateList = localDateList(totalAmountList.size(),beforeDays);

        String result = CalandarTaskText(taskName,dateList,stackAmountRangeList);
        System.out.println(result);
    }

    // 총 소요일 계산
    public static int calculateDays(int targetAmount, int dailyAmount, int increaseAmount){
        int achived = 0;
        int spendDay = 0;

        while(achived < targetAmount){
            achived += dailyAmount;
            spendDay++;
            dailyAmount += increaseAmount;
        }
        return spendDay;
    }

    // 일일 분량 계산
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

    // 2개의 일일 분량을 합친 리스트 생성 (정규분포 형태)
    public static List<Integer> sumAmountList(List<Integer> firstAmountList, List<Integer> secondAmountList){
        Collections.reverse(secondAmountList);
        List<Integer> sumList = new ArrayList<>(firstAmountList);

        int FirstPartLastOne = firstAmountList.get(firstAmountList.size()-1);
        int SecondPartFirstOne = secondAmountList.get(0);
        int FirstPartLastTwo = firstAmountList.get(firstAmountList.size()-2);

        if(FirstPartLastOne+SecondPartFirstOne <= FirstPartLastTwo){
            sumList.add(FirstPartLastOne+SecondPartFirstOne);
            sumList.remove(sumList.size()-2);
            secondAmountList.remove(0);
        }
        sumList.addAll(secondAmountList);

        return sumList;
    }


    // 누적 분량 계산
    public static List<Integer> stackAmountList(List<Integer> dailyAmountList, int achivedAmount){
        List<Integer> stackAmountList = new ArrayList<>();
        int stack = achivedAmount;
        for (Integer dailyAmount : dailyAmountList) {
            stack += dailyAmount;
            stackAmountList.add(stack);
        }
        return stackAmountList;
    }

    // 누적 분량 범위 계산
    public static List<String> stackAmountRangeList(List<Integer> dailyAmountList, int achivedAmount){
        List<String> stackRangeList = new ArrayList<>();
        int stack = achivedAmount;
        for (Integer dailyAmount : dailyAmountList) {
            stackRangeList.add(stack+"~"+(stack+dailyAmount)+" ("+dailyAmount+")");
            stack += dailyAmount;
        }
        return stackRangeList;
    }

    // n1일전부터 n2일까지의 날짜 계산하여 리스트로 반환
    public static List<LocalDate> localDateList(int days, int beforeDays){
        // 오늘 날짜
        List<LocalDate> dateList = new ArrayList<>();
        LocalDate startDay = LocalDate.now().minusDays(beforeDays);
        for(int i=0;i<days;i++){
            dateList.add(startDay.plusDays(i));
        }
        return dateList;
    }

    // 날짜 + 주제 + 분량 합치기
    public static String CalandarTaskText(String taskName, List<LocalDate> dateList, List<String> amountList) throws Exception {
        // 입력 오류시 예외처리
        if(dateList.size() != amountList.size()){
            throw new IOException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 문자열로 합쳐서 리스트에 저장
        for(int i=0;i<dateList.size();i++){
            String input = dateList.get(i) +" "+ taskName +" "+ amountList.get(i)+"\n";
            stringBuilder.append(input);
        }
        String TaskCalandarText = stringBuilder.toString();
        return TaskCalandarText;
    }
}
