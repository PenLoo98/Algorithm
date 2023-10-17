package lecture.week7;

import java.util.Scanner;

class Circle{
    int radius;
    double square;
    public Circle (int radius){
        this.radius=radius;
        this.square=3.14*radius*radius;
    }

    public void equals(Circle c2){
        if(radius == c2.radius){
            System.out.println("두 개의 원은 넓이가 같습니다.");}
        else {
            System.out.println("두 개의 원은 넓이가 다릅니다.");
            if(radius> c2.radius){
                System.out.printf("원1은(는) %.2f배 더 큽니다.", square/c2.square);
            }
            else{
                //radius< c2.radius
                System.out.printf("원1은(는) %.2f배 더 큽니다.", c2.square/square);
            }
        }
    }
}
public class CircleTest {
    public static void main(String[] args) {
        // 원의 반지름 입력
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 원의 반지름을 입력하세요:");
        int r1 = sc.nextInt();
        System.out.print("두 번째 원의 반지름을 입력하세요:");
        int r2 = sc.nextInt();
        Circle obj1 = new Circle(r1);
        Circle obj2 = new Circle(r2);

        // equals로 비교
        obj1.equals(obj2);
    }
}
