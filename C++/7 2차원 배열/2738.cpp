#include <iostream>
using namespace std;

int main(){
    // 행렬 크기 N*M을 입력받음
    int N,M;    
    cin >> N >> M;

    // 행렬 A,B를 입력받음
    int A[N][M], B[N][M];
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin >> A[i][j];
        }
    }
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin >> B[i][j];
        }
    }

    // 두 행렬을 더함
    int C[N][M];
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            C[i][j] = A[i][j] + B[i][j];
        }
    }

    // 결과값 출력
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cout << C[i][j] << " ";
        }
        cout << "\n";
    }
}