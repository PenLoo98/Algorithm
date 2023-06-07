#include <iostream>
#include <string>
using namespace std;

int main(){
    // 5*15 행렬 선언
    char Matrix[5][15] = {NULL,};

    // 행렬에 문자열 입력받음
    for(int i=0;i<5;i++){
        string str;
        cin >> str;
        for(int j=0;j<str.length();j++){
            Matrix[i][j] = str[j];
        }
    }

    // 결과값 출력
    for(int i=0;i<15;i++){
        for(int j=0;j<5;j++){
            if(Matrix[j][i] == NULL) continue;
            else cout << (char)Matrix[j][i];
        }
    }
    cout << '\n';
    return 0;
}