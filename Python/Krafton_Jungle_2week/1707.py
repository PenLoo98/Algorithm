import sys
input = sys.stdin.readline

# k: 테스트 케이스의 갯수
k = int(input())

for _ in range(k):
    # v: 정점의 갯수, e: 간선의 갯수
    v,e = map(int, input().split())
