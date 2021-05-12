from itertools import combinations


def solution(nums):
    number_combine = combinations(nums, 3)
    combined = [sum(comb) for comb in number_combine]
    max_num = max(combined)

    memo = [True] * (max_num + 1)
    memo[0], memo[1] + False
    for i in range(2, max_num + 1):
        if memo[i] is True:
            for j in range(i * i, max_num + 1, i):
                memo[j] = False

    answer = 0
    for num in combined:
        if memo[num] is True:
            answer += 1

    return answer


print(solution([1, 2, 3, 4]))
print(solution([1, 2, 7, 6, 4]))
