import sys
input = sys.stdin.readline

def dfs():
    # 재귀 종료 조건 
    if len(stack)==M:
        # 재귀 종료시 수행할 연산
        print(" ".join(map(str,stack)))
        return
    # 반복 탐색
    for i in range(1,N+1):
        # 탐색 판단 조건 (계속 탐색할지 넘어갈지)
        if visited[i]:
            continue
        # 반복할 때 실행할 연산 -> 자식 노드로 간다.
        visited[i] = True
        stack.append(i)
        # 재귀 함수
        dfs()
        # 조건이 맞지 않아 백트래킹시 할 연산 -> 부모 노드로 간다. 
        visited[i] = False
        stack.pop()

N,M = map(int, input().split())
stack = []
visited = [False]*(N+1)
dfs()