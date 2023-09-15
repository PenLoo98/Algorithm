package lecture;

import java.util.Scanner;

//
public class StringSwitchPizza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("피자 종류를 입력하시오: ");
        String model = sc.next();
        int price=0;
        switch(model){
            case"콤비네이션", "슈퍼슈프림": price = 20000; break;
            case"포테이토": price = 15000; break;
            case"쉬림프": price = 25000; break;
            default: break;
        }
        if(price ==0){
            System.out.printf("%s 피자는 없습니다.", model);
        }
        else{
            System.out.printf("피자 %s의 가격=%d",model,price);
        }
    }
}
