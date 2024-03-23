import sys
input = sys.stdin.readline

# 골드바흐 수: 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.

# 소수인지 판별하는 함수
def is_prime(num):
    cnt = 0
    for i in range(2,num+1):
        if(num%i==0):
            cnt+=1
    if(cnt==1):
        return True
    return False

# 2~Max까지의 소수를 구해 리스트로 만들기 
def make_prime_list(max):
    sosu_list = []    
    for i in range(2,max):
        if(is_prime(i)):
            sosu_list.append(i)
    return sosu_list

# 압력된 값에서 리스트에서 중복을 허용하여 두 소수를 뽑아 합이 일치하는 쌍 구하기 
def get_couple_sosu(num, sosu_list):
    big_prime = int(num/2)
    small_prime = int(num/2)

    # 합을 나타낸 두 수가 모두 소수인 경우
    if(big_prime in sosu_list and small_prime in sosu_list):
        return print(small_prime, big_prime)
    
    # 입력값/2+입력값/2가 소수에 없는 경우
    else:
        # 둘 중에 하나라도 소수가 아니면 값을 변경
        while(big_prime not in sosu_list or small_prime not in sosu_list):
            big_prime+=1
            small_prime-=1
        return print(small_prime, big_prime)
    
# 입력값 받기
T = int(input())
inputs = []
for i in range(0,T):
    inputs.append(int(input()))
maxValue = max(inputs)
prime_list = make_prime_list(maxValue)

for input in inputs:
    get_couple_sosu(input,prime_list)