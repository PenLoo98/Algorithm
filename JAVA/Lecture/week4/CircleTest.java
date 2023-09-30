package lecture.week4;

public class CircleTest {
    public static void main(String[] args) {
        Circle obj = new Circle();
        obj.radius = 100;
        obj.color = "blue";
        double area = obj.getArea();

        Circle objThis = new Circle();
        Circle objThis2 = new Circle(1);

        System.out.println("radius "+obj.radius+"의 원의 면적="+area);
        System.out.println("radius "+objThis.radius+"의 원의 면적="+objThis.getArea());
        System.out.println("radius "+objThis2.radius+"의 원의 면적="+objThis2.getArea());
    }

    public static class Circle{
        public int radius;
        public String color;

        // 메서드 오버로딩: 같은 이름의 메서드지만 매개변수에 따라 동작이 다름
        // 생성자 오버로딩: 같은 이름의 생성자지만 매개변수에 따라 동작이 다름
        public Circle(){
            this.radius=10;
        }
        public Circle(int radius){
            this.radius=radius;
        }
        public Circle(int radius, String color){
            this.radius=radius;
            this.color=color;
        }

        public double getArea(){
            return 3.14*radius*radius;
        }
    }
}
