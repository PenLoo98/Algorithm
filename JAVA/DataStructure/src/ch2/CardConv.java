package ch2;

import java.util.Arrays;

public class CardConv {
    public static void main(String[] args) {
        char[] d = new char[32];
        int x = 59;
        int r = 16;
        System.out.println(cardConv(x,r,d));
        System.out.println(Arrays.toString(d));
    }
    
    // 정숫값 x를 r진수로 변환하여 
    // 배열 d에 아랫자리부터 넣어 두고 자릿수를 반환
    static int cardConv(int x, int r, char[] d){
        int digit = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // 자릿수 저장
        do{
            d[digit++] = dchar.charAt(x%r);
            x/=r;
        } while(x>0);

        // 배열 역순으로 바꾸기
        for(int i=0;i<(d.length-1)/2;i++){
            char temp = d[i];
            d[i] = d[d.length-1-i];
            d[d.length-1-i] = temp;
        }
        return digit;
    }
    
}
