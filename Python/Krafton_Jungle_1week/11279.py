import sys
import heapq
input = sys.stdin.readline

queue = []

N = int(input())
for _ in range(N):
    number = int(input())
    # 입력이 자연수라면 배열에 추가 
    if number>0:
        heapq.heappush(queue,(-number,number))
    # 입력이 0이면 배열에서 가장 큰 값을 출력하고 그 값을 제거하는 경우이다.
    elif number ==0:
        # 큐가 비어있지 않다면
        if queue:
            print(heapq.heappop(queue)[1])
        # 큐가 비어있다면
        else:
            print(0) 