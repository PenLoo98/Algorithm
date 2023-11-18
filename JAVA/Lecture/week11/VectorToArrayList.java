package lecture.week11;

import java.util.ArrayList;
import java.util.Vector;

public class VectorToArrayList {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        ArrayList<String> arrayList = new ArrayList<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Orange");
        System.out.println("Vector의 데이터: ");
        for (String value : vector) {
            System.out.println(value);
            arrayList.add(value);
        }

        // vector가 비어있는지 확인
        vector.removeAllElements();
        if (vector.isEmpty()){
            System.out.println("Vector의 데이터는 비었음"+"\n");
        }

        System.out.println("ArrayList의 데이터: ");
        for (String value : arrayList){
            System.out.println(value);
        }
    }
}
