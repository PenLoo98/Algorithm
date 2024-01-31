import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = 1;
        int number = 666;

        while(index<N){
            number++;
            if(Integer.toString(number).contains("666")){
                index++;
            }
        }
        System.out.println(number);
    }
}
