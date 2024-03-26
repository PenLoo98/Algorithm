import sys
input = sys.stdin.readline

N,K=map(int,input().split())
inputs = [str(i+1) for i in range(N)]
answer = []
index = 0

while inputs:
    index = (index+K-1)%len(inputs)
    answer.append(inputs[index])
    inputs = inputs[:index]+inputs[index+1:]

print(f'<{", ".join(answer)}>')