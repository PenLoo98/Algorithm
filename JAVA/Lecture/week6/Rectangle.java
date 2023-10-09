package lecture.week6;

public class Rectangle extends Shape{
    int width, height;
    double calcArea(){
        return width*height;
    }
    void draw(){
        System.out.println("(" + x + "," + y + ") 위치에 "
                + "가로: " + width + " 세로: " + height);

    }

    public static void main(String[] args) {
        Rectangle obj = new Rectangle();
        obj.x = 10;
        obj.y = 20;
        obj.width = 30;
        obj.height = 40;
        obj.print();
        System.out.println("사각형의 넒이: " + obj.calcArea());
        obj.draw();
    }
}
