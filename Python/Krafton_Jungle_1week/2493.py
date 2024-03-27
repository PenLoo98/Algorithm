import sys
input = sys.stdin.readline
# 6 9 5 7 4

# 탑의 수 N 입력 
N = int(input())

# N개의 탑들의 높이 heights
heights = list(map(int, input().split()))
towers = [[heights[i],i+1] for i in range(N)]
tower_stack = []
answer = []

# 결과값 
for i in range(N):
    while tower_stack:
        # 이전 타워보다 지금 타워 높이가 낮은 경우
        if tower_stack[-1][0] <= heights[i]:
            tower_stack.pop()
        # 이전 타워보다 지금 타워 높이가 높은 경우
        elif tower_stack[-1][0] > heights[i]:
            answer.append(tower_stack[-1][1])
            break
    if not tower_stack:
        answer.append(0)
    tower_stack.append(towers[i])

answer = [str(i) for i in answer]
print(" ".join(answer))