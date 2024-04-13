import sys
import heapq
n_of_lecture = int(input())
lectures = []

## 강의를 [시작, 종료, 번호]로 lectures에 저장
for i in range(n_of_lecture):
    raw_input = sys.stdin.readline().split(" ")
    lecture = [int(raw_input[1]), int(raw_input[2]), int(raw_input[0])]
    lectures.append(lecture)

## 강의를 시작시간순으로 정렬
lectures = sorted(lectures)
# print(lectures)

# lec_rm은 {index}번 강의가 진행될 강의실
lec_rm = [0]*(n_of_lecture + 1)

## 가장 먼저 시작하는 강의 하나는 넣고 시작
l1 = lectures.pop(0)
lec_rm[l1[2]] = 1
# 강의실 정보 rooms는 각 강의실의 현재까지 마지막 강의의 (종료시간, 강의번호) 튜플이 저장됨
rooms = [(l1[1], l1[2])]
heapq.heapify(rooms)

for lecture in lectures:
    # 강의들 중에 끝나는 시간이 가장 이른 것 뒤에 올수있는지 확인
    earliet = rooms[0]

    if lecture[0] >= earliet[0]: # 들어갈 수 있으면, 팝해서 본 강의실 번호를 받고 강의실 정보에 추가
        lec_rm[lecture[2]] = lec_rm[earliet[1]]
        heapq.heappop(rooms)

    else: # 안되면, 현재 있는 강의실 수 +1 한 강의실 번호를 받고 강의실 정보에 추가
        lec_rm[lecture[2]] = len(rooms) + 1

    heapq.heappush(rooms,(lecture[1], lecture[2]))
    # print(rooms)
    # print(lec_rm)

print(len(rooms))
for i in range(1,n_of_lecture+1):
    print(lec_rm[i])