package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest2 {
    public static void main(String[] args) {
        // ()는 객체 생성자 호출

        Scanner sc = new Scanner(System.in);
        ArrayList<String> list2 = new ArrayList<>();

        while(true){
            System.out.println("이름을 입력하시오: ");
            String name = sc.next();
            if(name.equals("0")){
                break;
            }
            else{
                list2.add(name);
            }
        }


        // List 원소 제거
        ArrayList<String> list = new ArrayList<>();
        list.add("철수");
        list.add("영희");
        list.add("순신");
        list.add("자영");

        // List 출력
        System.out.print("List:");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.print("\n");

        // List2 출력
        System.out.print("List2:");
        for(int i=0;i<list2.size();i++){
            System.out.print(list2.get(i)+" ");
        }
        System.out.print("\n");

        // List-List2 출력
        System.out.print("(List-List2) : ");
        for(int i=0;i<list.size();i++){
            for(int j=0;i<list2.size();i++) {
                if (list.get(i).equals(list2.get(j))){
                    continue;
                }
                else{
                    System.out.print(list.get(i) + " ");
                }
            }
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
    }
}
