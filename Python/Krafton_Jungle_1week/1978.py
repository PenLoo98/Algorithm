import sys
input = sys.stdin.readline

N = int(input())
inputs = list(input().split(" "))


# 문자열 원소를 정수로 변환 + 1이면 제거
inputs = [int(i) for i in inputs if int(i)!=1]

# 소수의 개수 구하기
count = 0

# 소수인지 판별
for input in inputs:
    cnt = 0
    for i in range(2,input+1):
        # 나누어 떨어지는 경우
        if(input%i==0):
            cnt+=1
    # cnt가 1이면 소수이다.
    if(cnt == 1):
        count+=1;
# 결과 출력
print(count)