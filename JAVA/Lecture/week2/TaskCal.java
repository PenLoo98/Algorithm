package lecture;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TaskCal {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Total Amount: ");
        int totalAmount = Integer.parseInt(sc.nextLine());
        System.out.print("Start Point: ");
        int achivedAmount = Integer.parseInt(sc.nextLine());
        System.out.print("Daily Amount: ");
        int dailyAmount = Integer.parseInt(sc.nextLine());
        System.out.print("Daily Increase Amount: ");
        int increaseAmount = Integer.parseInt(sc.nextLine());
        System.out.print("before n days: ");
        int beforeDays = Integer.parseInt(sc.nextLine());
        System.out.print("Title: ");
        String taskName = sc.nextLine();

        totalAmount -= achivedAmount;

        int firstHalfAmount = totalAmount/2; // 150
        int secondHalfAmount = totalAmount/2; // 150
        if(totalAmount%2 != 0){
            firstHalfAmount += 1; // 151
        }

        int firstPartDays = calculateDays(firstHalfAmount,dailyAmount,increaseAmount);
        List<Integer> firstAmountList = dailyAmountList(firstPartDays,firstHalfAmount,dailyAmount,increaseAmount);

        int secondPartDays = calculateDays(secondHalfAmount,dailyAmount,increaseAmount);
        List<Integer> secondAmountList = dailyAmountList(secondPartDays,secondHalfAmount,dailyAmount,increaseAmount);

        List<Integer> totalAmountList = sumAmountList(firstAmountList,secondAmountList);

        List<String> stackAmountRangeList =stackAmountRangeList(totalAmountList,achivedAmount);

        // include all week
        List<LocalDate> dateList = localDateList(totalAmountList.size(),beforeDays);
        // exclude weekend
//        List<LocalDate> dateList = localDateListOffWeekends(totalAmountList.size(),beforeDays);

        String result = CalandarTaskText(taskName,dateList,stackAmountRangeList);
        System.out.println(result);
    }

    // calculate Total Days
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

    // calculate Daily Amount
    public static List<Integer> dailyAmountList(int days, int totalAmount,int dailyAmount, int increaseAmount){
        List<Integer> dailyAmountList = new ArrayList<>();
        int amount = dailyAmount;
        int stack = 0;
        for(int i=0;i<days;i++){
            stack += amount;
            // stack overflow total Amount
            if(stack > totalAmount){
                dailyAmountList.add(amount-(stack-totalAmount));
                break;
            }
            dailyAmountList.add(amount);
            amount += increaseAmount;
        }
        return dailyAmountList;
    }

    // Join Two Daily Amount
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


    // calculate Stacked Amount
    public static List<Integer> stackAmountList(List<Integer> dailyAmountList, int achivedAmount){
        List<Integer> stackAmountList = new ArrayList<>();
        int stack = achivedAmount;
        for (Integer dailyAmount : dailyAmountList) {
            stack += dailyAmount;
            stackAmountList.add(stack);
        }
        return stackAmountList;
    }

    // calculate Stacked Range Amount
    public static List<String> stackAmountRangeList(List<Integer> dailyAmountList, int achivedAmount){
        List<String> stackRangeList = new ArrayList<>();
        int stack = achivedAmount;
        for (Integer dailyAmount : dailyAmountList) {
            stackRangeList.add(stack+"~"+(stack+dailyAmount)+" ("+dailyAmount+")");
            stack += dailyAmount;
        }
        return stackRangeList;
    }

    // make LocalDate List before n days
    public static List<LocalDate> localDateList(int days, int beforeDays){
        List<LocalDate> dateList = new ArrayList<>();
        LocalDate startDay = LocalDate.now().minusDays(beforeDays);
        for(int i=0;i<days;i++){
            dateList.add(startDay.plusDays(i));
        }
        return dateList;
    }

    // make LocalDate List before n days excluding weekends
    public static List<LocalDate> localDateListOffWeekends(int days, int beforeDays){
        List<LocalDate> dateList = new ArrayList<>();
        LocalDate startDay = LocalDate.now().minusDays(beforeDays);
        int count = 0;
        while (count < days){
            // off weekends
            if(startDay.getDayOfWeek().getValue() != 6 && startDay.getDayOfWeek().getValue() != 7){
                dateList.add(startDay);
                count++;
            }
            startDay = startDay.plusDays(1);
        }
        return dateList;
    }

    // join DateTime + Title + Amount
    public static String CalandarTaskText(String taskName, List<LocalDate> dateList, List<String> amountList) throws Exception {
        if(dateList.size() != amountList.size()){
            throw new IOException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        // join String to input the list
        for(int i=0;i<dateList.size();i++){
            String input = dateList.get(i) +" "+ taskName +" "+ amountList.get(i)+"\n";
            stringBuilder.append(input);
        }
        return stringBuilder.toString();
    }
}
