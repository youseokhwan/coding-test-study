def solution(n):
    memo = [1, 1]

    def fibonacci(number):
        for i in range(2, number):
            memo.append(memo[i - 2] + memo[i - 1])

    fibonacci(n)
    answer = memo[-1] % 1234567
    return answer


print(solution(1))
print(solution(2))
print(solution(3))
print(solution(5))
