import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10_10814 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] inputs = new String[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            inputs[i][0] = st.nextToken();
            inputs[i][1] = st.nextToken();
        }

        Arrays.sort(inputs, (a,b) -> {
            if(Integer.parseInt(a[0]) < Integer.parseInt(b[0])){
                return(Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0])));
            }
            else if(Integer.parseInt(a[0]) > Integer.parseInt(b[0])){
                return(Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0])));
            }
            return 0;
        });

        for(int j=0;j<N;j++){
            sb.append(inputs[j][0]).append(" ").append(inputs[j][1]).append("\n");
        }

        System.out.println(sb);
    }
}
