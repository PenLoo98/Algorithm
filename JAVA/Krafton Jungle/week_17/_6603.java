import java.io.*;
public class _6603 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inputNumbers;
    static int[] selected = new int[6];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] input = br.readLine().split(" ");
            if(input[0].equals("0")) break;
            
            // 맨 처음 수 k는 개수를 나타낸다. 
            int k = Integer.parseInt(input[0]);
            inputNumbers = new int[k];
            for(int i=0;i<k;i++){
                inputNumbers[i] = Integer.parseInt(input[i+1]);
            }

            // k개의 수 중에서 6개를 뽑는다.
            combination(0, 0);
            bw.write("\n");
        }
        bw.flush(); 
        bw.close();
    }

    static void combination (int start, int size) throws IOException {
        if (size==6){
            for(int i=0;i<6;i++){
                bw.write(selected[i]+" ");
            }
            bw.write("\n");
            return ;
        }
        for(int i=start;i<inputNumbers.length;i++){
            selected[size]=inputNumbers[i];
            combination(i+1, size+1);
        }
    }    
}