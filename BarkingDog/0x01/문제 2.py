# https://blog.encrypted.gg/922?category=773649
# 1강 영상 15분 문제 2

from itertools import combinations


def arrayLL(N, lengthN):
    pick2s = list(combinations(N, 2))
    for pick2 in pick2s:
        if pick2[0] + pick2[1] == 100:
            return print(1)
    return print(0)


arrayLL({1, 52, 48}, 3)
