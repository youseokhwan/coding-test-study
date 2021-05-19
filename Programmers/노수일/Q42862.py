def solution(n, lost, reserve):
    for i in range(len(lost)):
        for j in range(len(reserve)):
            if reserve[j] == lost[i]:
                lost[i] = 0
                reserve[j] = 0
                break

    for i in range(len(lost)):
        if lost[i] != 0:
            for j in range(len(reserve)):
                if reserve[j] != 0:
                    if reserve[j] - 1 == lost[i] or reserve[j] + 1 == lost[i]:
                        lost[i] = 0
                        reserve[j] = 0
                        break

    answer = n
    for i in range(len(lost)):
        if lost[i] != 0:
            answer -= 1

    return answer


print(solution(5, [1, 2, 3, 4, 5], [1]))
print(solution(5, [2, 4], [1, 3, 5]))
print(solution(5, [2, 4], [3]))
print(solution(3, [3], [1]))
