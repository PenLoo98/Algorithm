package lecture.week6_2;

public class Triangle extends Shape{
    private int base, height;
    public Triangle(int x, int y, int b, int h){
        this.base = b;
        this.height = h;
        super.x = x;
        super.y = y;
    }

    public void draw() {
        System.out.printf("(%d,%d)위치에 base:%d height:%d Triangle을 그립니다.\n", x,y,base,height);
    }
}
