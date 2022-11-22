# https://www.acmicpc.net/problem/4673

self_numbers = []
for i in range(1, 10001):
    for j in str(i):
        i += int(j)
    if i <= 10000:
        self_numbers.append(i)

for k in range(1, 10001):
    if k not in self_numbers:
        print(k)










    



    

