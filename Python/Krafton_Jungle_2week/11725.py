import sys
input = sys.stdin.readline

n = int(input())
tree = {i:[] for i in range(1,n+1)}
for _ in range(n-1):
    first, second = map(int, input().split())
    tree[first].append(second)
    tree[second].append(first)

# 부모 노드를 찾기
parents = {i:-1 for i in range(1,n+1)}
visited = {i:False for i in range(1,n+1)}

def write_parent(start):
    # parents노드에 현재 노드의 부모 노드를 기록한다.
    parents[start]=0
    stack = [start]
    visited = [False]*(n+1)

    while stack:
        # pop으로 현재 노드를 꺼내 current에 저장한다.
        current = stack.pop()
        
        # 현재 꺼낸 노드의 연결 노드를 구한다.
        for node in tree[current]:
            if not visited[node]:
                stack.append(node)
                parents[node]=current
                visited[current] = True

write_parent(1)

for i in range(2,n+1):
    print(parents[i])