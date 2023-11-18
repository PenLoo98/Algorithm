package lecture.week12;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("milk");
        linkedList.add("bread");
        linkedList.add("butter");
        System.out.println(linkedList);

        linkedList.add(1,"apple");
        System.out.println(linkedList);
        linkedList.set(2, "grape");
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
    }
}
