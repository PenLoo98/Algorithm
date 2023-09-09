# https://www.acmicpc.net/problem/1475
# 참고사이트: https://bgspro.tistory.com/m/62
N = input()
N = N.replace('9', '6')
N = list(N)

# 0~8까지 카운트
cntlist = [0]*9
for i in range(9):
    cntlist[i] = N.count(str(i))
cntlist[6] = (cntlist[6]+1)//2
print(max(cntlist))