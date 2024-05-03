import java.util.*;
import java.io.*;

public class _1026{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0; i<n; i++){
            a[i] = a[i] * b[n-i-1];
        }
        System.out.println(Arrays.stream(a).sum());
    }
}