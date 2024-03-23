import sys
input = sys.stdin.readline

T = int(input())
# 문자열 S의 각 문자를 R번 반복한다 
for i in range(0,T):
    iterate, stringInput = input().split(" ")
    output = ""
    stringInput = stringInput.replace("\n", "")
    for char in stringInput:
        output += char*int(iterate)
    print(output)