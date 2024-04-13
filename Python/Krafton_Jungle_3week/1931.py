import sys
input = sys.stdin.readline
import heapq

n = int(input())
meet = []
for _ in range(n):
    start, end = map(int,input().split())
    meet.append((start,end))

# 정렬을 어떻게할까? 최소힙으로 해볼까?
meet.sort(key=lambda x: (x[1],x[0]))


