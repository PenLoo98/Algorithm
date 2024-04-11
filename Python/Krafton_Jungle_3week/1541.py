inputText = input()
split_minus = inputText.split('-')
answer = 0

# 첫 부호가 -이면 빼고 +면 더해준다.
first = sum(map(int, split_minus[0].split('+')))
if inputText[0]=='-':
    answer-= first
else: 
    answer+= first

for element in split_minus[1:]:
    element = sum(map(int, element.split('+')))
    answer-=element

print(answer)