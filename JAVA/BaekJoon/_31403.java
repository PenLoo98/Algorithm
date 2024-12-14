import java.io.*;

public class _31403 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        int a_int = Integer.parseInt(a);
        int b_int = Integer.parseInt(b);
        int c_int = Integer.parseInt(c);

        System.out.println(a_int+b_int-c_int);
        System.out.println(Integer.parseInt(a+b)-c_int);
    }
}