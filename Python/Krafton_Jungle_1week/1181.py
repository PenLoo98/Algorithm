import sys
input = sys.stdin.readline

N = int(input())
inputs = []
for _ in range(N):
    word =  input().replace("\n","")
    # 리스트에 없는 단어면 추가
    if(word not in inputs):
        inputs.append(word)

# 리스트를 길이 순으로 정렬 후, 사전 순으로 정렬
inputs.sort(key=lambda x: (len(x),x))
for word in inputs:
    print(word)
