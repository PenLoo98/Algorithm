import java.util.*;
import java.io.*;

public class _7983 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n: 과제의 수
        int n = Integer.parseInt(br.readLine());
        int[][] task = new int[n][2];
        
        // d: 과제 소요일, t: 과제 마감일
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            task[i][0] = Integer.parseInt(st.nextToken());
            task[i][1] = Integer.parseInt(st.nextToken());
        }
        // 과제 마감일이 늦은 순으로 정렬, 과제 마감일이 같다면 과제 소요일이 적은 순으로 정렬
        Arrays.sort(task, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });

        // 과제 마감일이 늦은 순으로 정렬된 task 배열을 순회하며 쉴 수 있는 날 계산 
        int startDeadline = task[0][1]-task[0][0];
        for(int i=1; i<n; i++){
            if(startDeadline < task[i][1]){
                startDeadline = startDeadline - task[i][0];
            }
            else{
                startDeadline = task[i][1] - task[i][0];
            }
        }
        System.out.println(startDeadline);
    }
}