package lecture;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {

        // ()는 객체 생성자 호출
        ArrayList<String> list = new ArrayList<>();
        list.add("철수");
        list.add("영희");
        list.add("순신");
        list.add("자영");

//        for(String obj: list){
//            System.out.println(obj+" ");
//        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
