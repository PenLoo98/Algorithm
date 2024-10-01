import java.util.*;
import java.io.*;

public class _8979 {
    static class Country{
        int number;
        int gold;
        int silver;
        int bronze;
        public Country(int number, int gold, int silver, int bronze){
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        ArrayList<Country> countries = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            
            countries.add(new Country(number, gold, silver, bronze));
        }
        
        // 금,은,동 많은 순으로 정렬
        Collections.sort(countries, new Comparator<Country>(){
            @Override
            public int compare(Country c1, Country c2){
                if(c1.gold==c2.gold){
                    if(c1.silver==c2.silver){
                        return c2.bronze-c1.bronze;
                    }
                    return c2.silver-c1.silver;
                }
                return c2.gold-c1.gold;
            }
        });

        int rank = 0;
        int sameRank = 1;
        for(int i=0;i<countries.size();i++){
            if (i>0 && countries.get(i).gold==countries.get(i-1).gold && countries.get(i).silver==countries.get(i-1).silver && countries.get(i).bronze==countries.get(i-1).bronze) {
                sameRank++;
            }
            else {
                rank += sameRank;
                sameRank = 1;
            }

            if(countries.get(i).number==k){
                bw.write(rank+"\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}