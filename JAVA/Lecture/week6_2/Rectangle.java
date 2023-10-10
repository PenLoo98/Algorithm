package lecture.week6_2;

public class Rectangle extends Shape {
    private int width, height;
    public Rectangle(int x, int y, int w, int h){
        this.width = w;
        this.height = h;
        super.x = x;
        super.y = y;
    }

    public void draw() {
        System.out.printf("(%d,%d)위치에 가로:%d 세로:%d Rectangle을 그립니다.\n", x,y,width,height);
    }
}
