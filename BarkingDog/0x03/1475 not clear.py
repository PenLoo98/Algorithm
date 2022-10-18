# https://www.acmicpc.net/problem/1475
# 문제 : 방 번호
# 입력 : 방 번호 N
# 출력 : 필요한 세트의 개수

N = input()
N = N.replace('9', '6')
N = list(N)

cntlist = []
count = 1
count6 = 0
for i in N:
    if i == '6':
        count6 += 1
        if count6%2 == 1 and count6 != 1:
            count += 1
            # print("count:",count)
    else:
        if i in cntlist:
            count += 1
            # print("count:",count)
        if i not in cntlist:
            cntlist.append(i)
print(count)





