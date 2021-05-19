def solution(d, budget):
    d.sort()

    answer = 0
    for dest in d:
        if budget - dest < 0:
            break
        budget = budget - dest
        answer += 1

    return answer


print(solution([1, 3, 2, 5, 4], 9))
print(solution([2, 2, 3, 3], 10))
