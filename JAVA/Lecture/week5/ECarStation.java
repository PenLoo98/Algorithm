// 202038364 손찬호
package lecture.week5;


public class ECarStation {
    public static int totalCharged = 0;
    private String name;
    private int battery;
    private int charge;

    public ECarStation(){
        this.battery = 100;
        this.charge = 0;
    }
    public ECarStation(String name, int battery){
        this.name = name;
        this.battery = battery;
        this.charge = 0;
    }

    // 충전할 에너지
    public void charging(int charge){
        this.charge += charge;
        totalCharged += charge;
    }

    // 충전한 정보
    public void getInfo(){
        System.out.println("*"+this.name);
        System.out.printf("배터리 %d%s, 충전할 에너지=%d\n",this.battery,'%',this.charge);
        System.out.printf("충전소에서 충전한 총 에너지=%d\n",totalCharged);
    }
}
