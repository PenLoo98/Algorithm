import java.io.*;
import java.util.*;

// 배운 거 
// 0->1, 1->0 반전 주는 법 : 1-switches[j]
// 범위 벗어나는지 미리 확인 : if(left<1 | right>n)


public class _1244 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 남학생: 자기가 받은 수의 배수 
        // 여학생: 자기가 받은 수를 중심으로 대칭 

        int n = Integer.parseInt(br.readLine()); // 스위치 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] switches = new int[n+1];
        for(int i=1; i<=n; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine()); // 학생 수
        for(int i=0; i<students; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); // 1: 남학생, 2: 여학생
            int num = Integer.parseInt(st.nextToken()); // 학생이 받은 수

            // 남학생: 받은 수의 배수에 해당하는 숫자의 상태를 반전
            if(gender==1){
                for(int j=num; j<=n; j+=num){ // 배수만큼 증가
                    switches[j] = 1-switches[j]; // 0->1, 1->0
                }
            }
            // 여학생: 받은 수의 대칭이 유지되는 최대의 범위만큼 상태를 반전
            else if(gender==2){
                int left = num-1;
                int right = num+1;

                // 범위를 벗어나면 받은 숫자만 반전
                if(left<1 | right>n){
                    switches[num] = 1-switches[num];
                }
                // 좌우가 다른 경우
                else if(switches[left]!=switches[right]){
                    switches[num] = 1-switches[num];
                }
                // 좌우가 같은 경우 
                else{
                    // 좌우 대칭이 유지될 때까지 탐색
                    while(switches[left]==switches[right]){
                        left--;
                        right++;
                        // 범위를 벗어나면 종료
                        if(left<1 | right>n){
                            break;
                        }
                    }
                    for(int j=left+1;j<=right-1;j++){
                        switches[j] = 1-switches[j];
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            bw.write(switches[i]+" ");
            if(i%20==0){
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
