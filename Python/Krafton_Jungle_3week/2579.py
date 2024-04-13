# n: 계단의 개수(n>=300)
n = int(input())

# stairs: 계단의 점수(1<=stairs<=10000)
stairs = [int(input()) for _ in range(n)]

# 점수 계산
point = [0] * (n)

if len(stairs) <= 2:
    print(sum(stairs))
else:
    point[0] = stairs[0]
    point[1] = stairs[0] + stairs[1]
    point[2] = max(stairs[0] + stairs[2], stairs[1] + stairs[2])
    for i in range(3, n):
        point[i] = max(point[i-3] + stairs[i-1] + stairs[i], point[i-2] + stairs[i])
    print(point[n-1])

# i=4 -> 1 1 0 1 -> point[i-2]+stairs[i] = 30+25 = 55
# i=4 -> 1 0 1 1 -> point[i-3]+stairs[i-1]+stairs[i] = 10+15+25 = 50
# i=4 -> 1 1 1 0 -> 연속된 3개의 계단을 밟으므로 불가능