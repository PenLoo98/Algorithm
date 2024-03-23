import sys
input = sys.stdin.readline

# 골드바흐 수: 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
T = int(input())

# 소수인지 판별하는 함수
def is_sosu(num):
    cnt = 0
    for i in range(2,num+1):
        if(num%i==0):
            cnt+=1
    if(cnt==1):
        return True
    return False

# 2~Max까지의 소수를 구해 리스트로 만들기 
def make_sosu_list(max):
    sosu_list = []    
    for i in range(2,max):
        if(is_sosu(i)):
            sosu_list.append(i)
    return sosu_list

# 리스트에서 중복을 허용하여 두 소수를 뽑아 합이 일치하는 쌍 구하기 
def get_couple_sosu(num, sosu_list):
    couple_list = []
    # 짝수가 두 소수의 합으로 표현되는 경우 리스트에 추가 
    for i in sosu_list:
        for j in sosu_list:
            if(num==i+j):
                couple_list.append((i,j))
                break
    # 두 소수의 차이가 가장 적은 1쌍
    min_couple = couple_list[0]
    min_dif = abs(couple_list[0][0] - couple_list[0][1])
    for couple in couple_list:
        diff = abs(couple[0]-couple[1])
        if(diff<min_dif):
            min_couple = couple
            min_dif = diff
    if(min_couple[0] > min_couple[1]):
        temp = min_couple[1]
        min_couple[1] = min_couple[0]
        min_couple[0] = temp
    return print(min_couple[0], min_couple[1])
        
    
inputs = []
# T번 숫자를 입력받고 리스트에 저장
for i in range(0,T):
    inputs.append(int(input()))

# 입력받은 값 중 최대값을 구한다. 
maxValue = max(inputs)

sosu_list = make_sosu_list(maxValue)

# 구한 소수쌍 중 차이가 가장 작은 것을 출력한다.
for input in inputs:
    get_couple_sosu(input, sosu_list)