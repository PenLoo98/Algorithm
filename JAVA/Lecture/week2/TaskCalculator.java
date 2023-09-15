package lecture;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskCalculator {
    public static void main(String[] args) {
//        calculateDays(1000,10,2);
//        System.out.println(localDateList(10));
        System.out.println(calculateAmount(28,10,2));

    }
    
    // 매일 조금씩 증가하는 목표를 설정 후 총 몇일이 걸리는 지 계산
    // 총 분량, 시작 분량, 분량 증가량
    public static void calculateDays(int targetAmount, int startAmount, int increaseAmout){
        int achived = 0;
        int spendDay = 0;

        while(achived < targetAmount){
            achived += startAmount;
            spendDay++;
            startAmount += increaseAmout;
        }
        System.out.printf("총 소요시간은 %d일입니다.\n",spendDay);
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

    // 오늘부터 n일까지 분량의 증가량 리스트
    public static List<Integer> calculateAmount(int totalDays, int startAmount, int increaseAmout){
        // (옵션)마지막 날은 총 분량을 넘기는 경우 따로 처리
        List<Integer> amountList = new ArrayList<>();
        for(int i=0;i<totalDays;i++){
            amountList.add(startAmount+i*increaseAmout);
        }
        return amountList;
    }
}
