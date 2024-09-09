import java.util.*;
import java.io.*;

public class _7568 {
    static class Person{
        int weight;
        int height;
        public Person(int weight, int height){
            this.weight = weight;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> people = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people.add(new Person(weight, height));
        }

        for(int i=0;i<n;i++){
            int rank = 1;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(people.get(i).weight<people.get(j).weight && people.get(i).height<people.get(j).height){
                    rank++;
                }
            }
            System.out.print(rank+" ");
        }
    }
}