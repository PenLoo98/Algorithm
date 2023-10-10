package lecture.week6_2;

public class ShapeTest {
    public static void main(String[] args) {
        Shape[] arrayOfShapes = new Shape[3];
        arrayOfShapes[0] = new Rectangle(6, 6, 10, 20);

        // arrayOfShapes[1] Shape타입이니까 x,y는 참조가 된다.
        // 하지만 base, height는 참조가 안된다.
        // 다운캐스팅해야지만 base, height로 참조가 된다.
        arrayOfShapes[1] = new Triangle(8, 8, 30, 40);
        arrayOfShapes[2] = new Circle(7, 7, 50);

        for(int i=0; i<arrayOfShapes.length; i++) {
            arrayOfShapes[i].draw();
            System.out.println(arrayOfShapes[i] instanceof Shape);
        }
    }
}
