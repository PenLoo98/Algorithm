import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4_2563 {
    public static void main(String[] args) throws IOException {
        // 색종이 수 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 100*100개의 타일을 boolean 타입으로 생성
        boolean[][] allArea = new boolean[100][100];
        // 종이 수 만큼 위치 입력
        for(int i=0;i<N;i++){
            // 데이터 타입은 무엇? -> 2차원 배열
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 해당하는 영역 true 로 변환
            for(int j=a; j<a+10 & j<allArea.length ;j++){
                for(int k=b; k<b+10 & k<allArea[j].length ;k++){
                    allArea[j][k]=true;
                }
            }
        }
        // true 갯수 세기: 방법1 이중 for문
        int count = 0;
        for(int i=0;i<allArea.length;i++){
            for(int j=0;j<allArea[i].length;j++){
                if(allArea[i][j]){
                    count++;
                }
            }
        }

//        // true 갯수 세기: 방법2 Stream
//        long count = Stream.of(allArea)
//            .flatMap(row -> IntStream.range(0, row.length).mapToObj(i -> row[i]))
//            .filter(val -> val)
//            .count();

        // true로 바뀐 넓이 출력
        System.out.println(count);
    }
}