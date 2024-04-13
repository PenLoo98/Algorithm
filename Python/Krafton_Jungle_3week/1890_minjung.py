n_of_square = int(input())
board = []
for _ in range(n_of_square):
    row_raw = input().split(" ")
    row = []
    for entry in row_raw:
        row.append(int(entry))
    board.append(row)

## case가 dp table임. 해당 칸에 도착할 수 있는 경우의 수
case = [[0]*n_of_square for _ in range(n_of_square)]

# print(board)
# print(case)

for j in range(n_of_square):
    for i in range(n_of_square):
        if i==0 and j==0:
            case[j][i] = 1
            continue
        itr1 = 1
        itr2 = 1
      # 왼쪽에서 올수있는 경우 그 칸까지 도달할 수 있는 경우의 수를 더해준다.
        while(i>=itr1):
            if board[j][i-itr1] == itr1: case[j][i] += case[j][i-itr1]
            itr1 += 1
      #위에서 오는 경우 그 칸까지 도달할 수 있는 경우의 수를 더해준다.
        while(j>=itr2):
            if board[j-itr2][i] == itr2: case[j][i] += case[j-itr2][i]
            itr2 += 1

# print(case)
print(case[n_of_square-1][n_of_square-1])