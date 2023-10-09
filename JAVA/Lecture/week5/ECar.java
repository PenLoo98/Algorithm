// 202038364 손찬호
package lecture.week5;

public class ECar extends ECarStation{
    public static void main(String[] args) {
        ECarStation EV6 = new ECarStation("EV6",30);
        ECarStation Ionic6 = new ECarStation("Ionic6",50);

        EV6.charging(70);
        EV6.getInfo();
        System.out.println();
        Ionic6.charging(50);
        Ionic6.getInfo();
    }
}
