import java.io.*;
import java.util.*;

public class _5587 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> SGcards = new ArrayList<>();
        ArrayList<Integer> GScards = new ArrayList<>();
        for(int i=0;i<n;i++){
            SGcards.add(Integer.parseInt(br.readLine()));
        }
        for(int i=1;i<=2*n;i++){
            if(!SGcards.contains(i)){
                GScards.add(i);
            }
        }
        Collections.sort(SGcards);
        Collections.sort(GScards);

        // System.out.println(SGcards);
        // System.out.println(GScards);

        CardGame(SGcards, GScards);
    }

    static void CardGame(ArrayList<Integer> SGcards, ArrayList<Integer> GScards){
        int currentOnCard = 0; // 현재 놓여있는 카드

        int beforeSize = 0;
        int afterSize = 0;
        
        // 둘 중 하나라도 전부 비우기 전까지 계속 진행한다.
        while(true){
            // 상근이가 카드를 낸다.
            beforeSize = SGcards.size();
            for(int i=0;i<SGcards.size();i++){
                // 현재 놓인 카드보다 크면 카드를 내기
                int drawCard = SGcards.get(i);
                if(drawCard>currentOnCard){
                    currentOnCard = drawCard;
                    SGcards.remove(i);
                    break;
                }    
            }
            afterSize = SGcards.size();
            // 낼 카드가 없는 경우 
            if(beforeSize==afterSize){
                currentOnCard = 0;
            }
            // 카드를 비우면 종료
            if(afterSize==0){
                break;
            }

            // 근상이가 카드를 낸다.
            beforeSize = GScards.size();
            for(int i=0;i<GScards.size();i++){
                // 현재 놓인 카드보다 크면 카드를 내기
                int drawCard = GScards.get(i);
                if(drawCard>currentOnCard){
                    currentOnCard = drawCard;
                    GScards.remove(i);
                    break;
                }    
            }
            afterSize = GScards.size();
            // 낼 카드가 없는 경우 
            if(beforeSize==afterSize){
                currentOnCard = 0;
            }
            // 카드를 비우면 종료
            if(afterSize==0){
                break;
            }
        }

        // 상대가 가진 갯수 출력
        System.out.println(GScards.size());
        System.out.println(SGcards.size());
    }
}