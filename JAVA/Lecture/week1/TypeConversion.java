package Lecture;

public class TypeConversion {
    public static void main(String[] args) {
        int i;
        double f;

        // 묵시적 형변환
        f = 1 / 5;
        System.out.println(f);

        // 명시적 형변환
        f = (double) 1 / 5;
        System.out.println(f);
    }
}
