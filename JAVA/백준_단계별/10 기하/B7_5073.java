import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B7_5073 {
    public static void main(String[] args) throws IOException {
        // 삼각형 3개 변을 입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            // 한줄을 입력받음
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // int타입 리스트에 크기순으로 정렬
            List<Integer> edges = new ArrayList<>();
            edges.add(Integer.parseInt(st.nextToken()));
            edges.add(Integer.parseInt(st.nextToken()));
            edges.add(Integer.parseInt(st.nextToken()));
            edges = edges.stream().sorted().collect(Collectors.toList());

            int max = edges.get(2);
            int mid = edges.get(1);
            int min = edges.get(0);

            // 입력 0 0 0
            if(min==0){
                break;
            }
            // 삼각형인지 확인
            if(max >= mid+min){
                System.out.println("Invalid");
                continue;
            }
            // 삼각형 유형 확인
            if(max==mid & max==min){
                System.out.println("Equilateral");
            } else if (max==mid | mid==min) {
                System.out.println("Isosceles");
            } else{
                System.out.println("Scalene");
            }
        }
    }
}