import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4_2563 {
    public static void main(String[] args) throws IOException {
        // 색종이 수 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] axios = new int[100][2];

        // 종이 수 만큼 위치 입력
        for(int i=0;i<N;i++){
            // 데이터 타입은 무엇? -> 2차원 배열
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 처음입력

        }

        // 겹치는 넓이 = 전체 갯수 넓이 - 겹치는 부분 넓이
        // 가로,세로 10
        // 겹치는지 어떻게 확인하지? -> [x 좌표값 차이가 10이하일 때] or [y 좌표값 차이가 10이하일 때]
        // 겹치는 넓이를 어떻게 구하지? -> 좌표값 차이가 10이하일 때 (10 - 좌표값 차이)
        // 1번째와 3번째 겹치는 경우 어떻게 데이터를 저장하고 비교해야할까?
        // (3,7 - 5,2 - 5,7)의 넓이: 100+20+50 = 170 // 40+80+50

        // 3개가 겹치는 경우는 어떻게 해야할까?
        // 해결책1: 전체넓이-겹치는 넓이 빼기
        // 해결책2: 겹치는 넓이 더하기 = (10-좌표값 차이)^2

        // 보이는 넓이 구하고 출력
    }
}