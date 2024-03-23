import sys
input = sys.stdin.readline

N = int(input())
inputs = []
for i in range(0,N):
    inputs.append(int(input()))
inputs.sort()
# 결과 출력 1: 문자열로 바꾸어 줄바꿈 문자열을 하나의 문자로 연결한다.
# inputs = [str(i) for i in inputs]
# output = "\n".join(inputs)
# print(output)
# 결과 출력 2: 리스트에서 하나씩 뽑아서 출력한다.
for output in inputs:
    print(output)