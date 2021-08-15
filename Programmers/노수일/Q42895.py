def solution(N, number):
    if N == number:
        return 1
    answer = -1
    memo = [set() for _ in range(8)]
    for i, x in enumerate(memo, start=1):
        x.add(int(str(N) * i))
    for i in range(1, 8):
        for j in range(i):
            for op1 in memo[j]:
                for op2 in memo[i - j - 1]:
                    memo[i].add(op1 + op2)
                    memo[i].add(op1 - op2)
                    memo[i].add(op1 * op2)
                    if op2 != 0:
                        memo[i].add(op1 // op2)
        if number in memo[i]:
            answer = i + 1
            break
    return answer


"""
12 = 5 + 5 + (5 / 5) + (5 / 5)
12 = 55 / 5 + 5 / 5
12 = (55 + 5) / 5

[{5},{55},{555},{555} ...]
"""