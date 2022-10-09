# https://www.acmicpc.net/problem/2941

word = str(input())

croatia = ['c=','c-','dz=','d-','lj','nj','s=','z=']
for i in croatia:
  if word.find(i)>=0:
    word = word.replace(i,'*')
print(len(word))