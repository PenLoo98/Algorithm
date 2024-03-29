import sys
input = sys.stdin.readline

def dfs():
    # 재귀 종료 조건
    if len(stack)==m:
        # 중복을 허용하지 않으려면 어떻게 해야하지?
        # 지난 번에 출력하지 않은 조합인 경우
        sorted_stack = sorted(stack)
        if sorted_stack not in success_cases:
            success_cases.append(sorted_stack)
            print(" ".join(map(str,stack)))
        return
    # 반복문 
    for i in range(1,n+1):
        # 탐색할 조건 
        if visited[i]:
            continue
        # 탐색시 반복 수행할 연산
        visited[i] = True
        stack.append(i)
        # 재귀함수
        dfs()
        # 백트래킹시 수행할 연산
        visited[i] = False
        stack.pop()

n,m = map(int, input().split())
stack = []
success_cases = []
visited = [False]*(n+1)
dfs()