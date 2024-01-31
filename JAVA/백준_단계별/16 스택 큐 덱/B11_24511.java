import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11_24511 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arrayA = new int[N];
        for(int i=0;i<N;i++){
            arrayA[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] arrayB = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            arrayB[i]=Integer.parseInt(st.nextToken());
            if(arrayA[i]==0){
                deque.addFirst(arrayB[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for(int i=0;i<M;i++){
           deque.addLast(Integer.parseInt(st.nextToken()));
           sb.append(deque.poll());
           if(i!=M-1){
               sb.append(" ");
           }
        }

        System.out.println(sb);
    }
}
