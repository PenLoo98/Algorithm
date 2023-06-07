#include <iostream>

using namespace std;

int main(){
    // 9*9 행렬 선언
    int Nine[9][9];
    int max = 0;
    int x=0, y=0;

    // 행렬을 입력받음
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            cin >> Nine[i][j];
            if(Nine[i][j] > max){
                max = Nine[i][j];
                x = i;
                y = j;
            }
            else continue;
        }
    }

    // 최댓값과 그 위치를 출력
    cout << max << "\n";
    cout << x+1 << " " << y+1 << endl;

}