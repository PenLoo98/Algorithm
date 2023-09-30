package ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10986 {
    public static void main(String[] args) throws IOException {
        // N, M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 배열 입력받기
        Long[] A = new Long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i]=Long.parseLong(st.nextToken());
        }

        // S 구하기
        Long[] S = new Long[N];
        S[0]=A[0];
        for(int i=1;i<N;i++){
            S[i]=A[i]+S[i-1];
        }

        // S%M 만들기
        long count = 0;
        for(int i=0;i<S.length;i++){
            S[i] = S[i]%M;
            if(S[i]%M == 0){
                count++;
            }
        }

        // S의 원소 중복 세고 C에 저장
        Long[] C = new Long[M];
        for(int i=0;i<C.length;i++){
            long cnt = 0;
            for(int j=0;j<S.length;j++){
                if(i==S[j]){
                    cnt++;
                }
            }
            C[i]=cnt;
        }

        // C에 저장한 중복 수를 nC2로 계산해 count에 더함
        for(int i=0;i<C.length;i++){
            // nC2 = n*n-1/2
            long n = C[i];
            count += (n*(n-1))/2;
        }
        System.out.println(count);
    }
}
