#include <iostream>
#include <string>

using namespace std;

int changeToDecimal(string Num, int jin){
    // 결과값 선언
    int result;
    int len = Num.length() - 1;

    // 문자열을 하나씩 분리 

    // ZZZZZ = 35*36^4+35*36^3+35*36^2+35*36^1+35*36^0
    for(int i=0;i<Num.length();i++){
        result += Num[i];
    }


    return result;
}

int wordToNumber(char word){
    if(word == 'A'){
        return 10;
    }
    else if(word == 'B'){
        return 11;
    }
    else if(word == 'C'){
        return 12;
    }
    else if(word == 'D'){
        return 13;
    }
    else if(word == 'E'){
        return 14;
    }
    else if(word == 'F'){
        return 15;
    }
    else if(word == 'G'){
        return 16;
    }
    else if(word == 'H'){
        return 17;
    }
    else if(word == 'I'){
        return 18;
    }
    else if(word == 'J'){
        return 19;
    }
    else if(word == 'K'){
        return 20;
    }
    else if(word == 'L'){
        return 21;
    }
    else if(word == 'M'){
        return 22;
    }
    else if(word == 'N'){
        return 23;
    }
    else if(word == 'O'){
        return 24;
    }
    else if(word == 'P'){
        return 25;
    }
    else if(word == 'Q'){
        return 26;
    }
    else if(word == 'R'){
        return 27;
    }
    else if(word == 'S'){
        return 28;
    }
    else if(word == 'T'){
        return 29;
    }
    else if(word == 'U'){
        return 30;
    }
    else if(word == 'V'){
        return 31;
    }
    else if(word == 'W'){
        return 32;
    }
    else if(word == 'X'){
        return 33;
    }
    else if(word == 'Y'){
        return 34;
    }
    else if(word == 'Z'){
        return 35;
    }
    else{
        return word - '0';
    }

}

int main(){
    string N = "ZZZZZ";
    int B = 36;

    // B진법 수 N을 입력받음
    // cin >> N >> B;

    // 10진법으로 변환
    // cout << changeToDecimal(N,B) << endl;




    // 결과값 선언
    int result;
    int len = N.length() - 1;

    // 문자열을 하나씩 분리 

    // ZZZZZ = 35*36^4+35*36^3+35*36^2+35*36^1+35*36^0
    // for(int i=0;i<N.length();i++){
    //     result += N[i]
    // }

    return 0;
}