# https://www.acmicpc.net/problem/1316

# 입력할 단어 갯수 입력
N = int(input())

count = 0
for i in range(0, N):
    # 단어 입력
    word = str(input())
    alphabets = []

    # 단어의 알파뱃 중복없이 순서대로 저장
    for alphabet in word:
        if alphabet not in alphabets:
            alphabets.append(alphabet)

    # 저장한 알파뱃 순서대로 삭제
    for alphabet in alphabets:
        word = word.lstrip(alphabet)

    # 다 삭제되었으면 연속문자 => 카운트 추가
    if word == '':
        count += 1

print(count)




