package lecture.week6_2;

public class Circle extends Shape{
    private int radius;
    public Circle(int x, int y, int r){
        this.radius = r;
        super.x = x;
        super.y = y;
    }
    public void draw() {
        System.out.printf("(%d,%d)위치에 radius:%d Circle을 그립니다.\n", x,y,radius);
    }
}
