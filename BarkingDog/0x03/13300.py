# https://www.acmicpc.net/problem/13300

# 성별/학년 같도록 방 배정

N, K = map(int, input().split())
people = [0]*12
room = 0
for _ in range(N):
    S, Y = map(int, input().split())
    if S == 0:
        people[Y-1] += 1
    elif S == 1:
        people[Y+5] += 1
for i in people:
    room += (i+K-1)//K
print(room)





