package lecture.week12;

import java.util.ArrayList;
import java.util.Collections;

class Card {
    String suit;
    String number;

    public Card(String suit, String number) {
        this.suit = suit;
        this.number = number;
    }

    public String toString() {
        return "(" + suit + " " + number + ")";
    }
}

class Deck{
    ArrayList<Card> deck = new ArrayList<Card>();
    String[] suits = {"CLUB", "DIAMOND", "HEART", "SPADE"};
    String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public Deck(){
        for(int i=0;i < suits.length; i++){
            for(int j = 0;j < numbers.length; j++){
                deck.add(new Card(suits[i], numbers[j]));
                System.out.print(new Card(suits[i], numbers[j]));
            }
            System.out.println();
        }
        System.out.println();
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Card deal(){
        return deck.remove(0);
    }

    public static void deal5Card(Player p1, Player p2,Deck deck){
        for(int i=1;i<=5;i++){
            Card card1 = deck.deal();
            p1.getCard(card1);
            System.out.printf("p1 #%d card=%d\n", i, getScore(card1));

            Card card2 = deck.deal();
            p2.getCard(card2);
            System.out.printf("p2 #%d card=%d\n", i, getScore(card2));
            System.out.println();
        }
    }

    public static int getScore(Card card){
        int score=0;
        switch (card.number){
            case "A": {score+=1; break;}
            case "2": {score+=2; break;}
            case "3": {score+=3; break;}
            case "4": {score+=4; break;}
            case "5": {score+=5; break;}
            case "6": {score+=6; break;}
            case "7": {score+=7; break;}
            case "8": {score+=8; break;}
            case "9": {score+=9; break;}
            case "10": {score+=10; break;}
            case "J": {score+=11; break;}
            case "Q": {score+=12; break;}
            case "K": {score+=13; break;}
        }
        return score;
    }

    public static int calculateTotalScore(Player player){
        int score = 0;
        for (Card card: player.list){
            score += getScore(card);
        }
        return score;
    }
}

class Player{
    ArrayList<Card> list = new ArrayList<Card>();
    public void getCard(Card card){
        list.add(card);
    }
    public void showCards(){
        System.out.println(list);
    }
}

public class CardGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Player p1 = new Player();
        Player p2 = new Player();
        Deck.deal5Card(p1,p2,deck);

        System.out.print("p1: ");
        p1.showCards();
        System.out.print("p2: ");
        p2.showCards();

        // TODO: 뽑은 카드의 숫자합 구하기
        int p1Score = Deck.calculateTotalScore(p1);
        int p2Score = Deck.calculateTotalScore(p2);

        // TODO: 더 높은 점수의 플레이어 출력
        String result="";
        if(p1Score > p2Score){
            result="p1 win";
        }
        else if (p1Score == p2Score){
            result="draw";
        }
        else {
            result="p2 win";
        }

        // TODO: 결과 출력
        System.out.print("p1="+p1Score+" "+"p2="+p2Score+" -> "+ result);
    }
}
