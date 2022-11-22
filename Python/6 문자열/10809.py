# 단어 입력
S = str(input()).lower()
# print(S)

# 알파뱃 리스트 생성
from string import ascii_lowercase

alpha_list = list(ascii_lowercase)
# print(alpha_list)

# 단어 인덱스 파악
word = []
for i in S:
    word += i
# print(word)

# 각 알파뱃에 단어 인덱스로 치환 (문자열 >> 숫자로)
result = []
for j in alpha_list:
    if j in word:
        result += [word.index(j)]
    elif j not in word:
        result += [-1]
# print(result)

# 띄워쓰기로 구분하며 출력
for k in result:
    print(f"{k}" + " ", end='')
