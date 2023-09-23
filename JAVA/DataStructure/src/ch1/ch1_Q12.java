package ch1;

public class ch1_Q12 {
    public static void main(String[] args) {
        System.out.println(" | 1 2 3 4 5 6 7 8 9");
        System.out.println("-+------------------");
        for(int i=1;i<10;i++){
            System.out.printf("%d|",i);
            for(int j=1;j<10;j++){
                System.out.printf(" %d",i+j);
            }
            System.out.print("\n");
        }
    }
}
