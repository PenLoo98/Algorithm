import java.util.*;
import java.io.*;

public class _13417 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            Deque<Character> deque = new ArrayDeque<>();

            // 입력받은 문자열을 덱에 넣는다.
            for(int j=0;j<input.length;j++){
                // 첫번째는 그냥 더한다. 
                Character firstCard = input[j].charAt(0);
                if(j==0){
                    deque.add(firstCard);
                }
                // 두번째부터는 첫번째와 비교해서 더한다.
                else{
                    Character currentCard = input[j].charAt(0);
                    // 첫번째보다 작으면 왼쪽에 추가 
                    if(Character.compare(deque.getFirst(), currentCard) >= 0){
                        deque.addFirst(currentCard);
                        // System.out.println(deque);
                    }
                    // 크거나 같으면 오른쪽에 추가
                    else{
                        deque.addLast(currentCard);
                        // System.out.println(deque);
                    }
                }
            }

            // // 덱에 순서대로 문자열로 합침: +연산자
            // String result = "";
            // for(Character c: deque){
            //     result += c;
            // }

            // 덱에 순서대로 문자열로 합침: StringBuilder
            StringBuilder sb = new StringBuilder();
            for(Character c: deque){
                sb.append(c);
            }
            String result = sb.toString();

            System.out.println(result);
        }
    }
}
