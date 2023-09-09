# https://www.acmicpc.net/problem/10808

S = input()
alphabet_list = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
alphabet_each_count = [0]*26

for i in range(len(alphabet_list)):
    alphabet_each_count[i] = S.count(alphabet_list[i])

for i in alphabet_each_count:
    print(i, end=' ')
