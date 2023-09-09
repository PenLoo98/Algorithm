# https://www.acmicpc.net/problem/1919

A = input()
B = input()
A = sorted(A)
B = sorted(B)
count = 0
for i in A:
    if i in B:
        B.remove(i)
    else:
        count += 1
print(count + len(B))


