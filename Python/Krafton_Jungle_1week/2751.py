import sys
input = sys.stdin.readline

N = int(input())
inputs = []
for _ in range(0,N):
    inputs.append(int(input()))
inputs.sort()
for output in inputs:
    print(output)