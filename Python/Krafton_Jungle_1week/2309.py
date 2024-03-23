import sys
input = sys.stdin.readline

heights = []
for _ in range(9):
    heights.append(int(input()))
total = sum(heights)
getValue = total - 100

# getValue에 해당하는 두 수를 구하기
long = len(heights)
index1=0;
index2=0;
for i in range(0,long-1):
    for j in range(i+1,long):
        if(getValue==heights[i]+heights[j]):
            value1=heights[i]
            value2=heights[j]
            break
        
# 두 수를 heights에서 제거
heights.remove(value1)
heights.remove(value2)

# heights의 키를 오름차순으로 정렬 후 출력 
heights.sort()

for height in heights: 
    print(height)