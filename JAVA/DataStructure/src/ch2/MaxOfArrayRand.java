package ch2;

import java.util.Random;

public class MaxOfArrayRand {
    static int maxOf(int[] a) {
        int max = a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("키의 최댓값을 구합니다.");
        int number = random.nextInt(10);
        System.out.printf("사람 수: %d",number);

        int[] height = new int[number];

        System.out.println("높이값은 다음과 같습니다.");
        for(int i=0; i<number;i++){
            height[i] = 100 + random.nextInt(90);
        }

    }
}
