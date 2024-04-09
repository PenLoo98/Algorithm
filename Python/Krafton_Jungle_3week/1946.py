import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    applicant = []
    for _ in range(n):
        applicant.append(tuple(map(int,input().split())))
        applicant.sort()
    print(applicant)

