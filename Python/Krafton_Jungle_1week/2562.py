import sys
input = sys.stdin.readline

# 9번 입력을 받음
input_list = []
for i in range(1,10):
    input_list.append(int(input()))

# 받은 입력의 최대값을 구함 
print(max(input_list))

#  받은 최대값의 인덱스를 구함
print(input_list.index(max(input_list))+1)