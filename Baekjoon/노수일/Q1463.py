from sys import stdin

n = int(stdin.readline())
memo = [0 for _ in range(n + 1)]

for i in range(2, n + 1):
    memo[i] = memo[i - 1] + 1
    if i % 2 == 0:
        memo[i] = min(memo[i], memo[i // 2] + 1)
    if i % 3 == 0:
        memo[i] = min(memo[i], memo[i // 3] + 1)

print(memo[n])

# for i in range(2, n + 1):
#     if i % 3 == 0:
#         memo[i] = min(memo[i // 3], memo[i // 2], memo[i - 1]) + 1
#     elif i % 2 == 0:
#         memo[i] = min(memo[i // 2], memo[i - 1]) + 1
#     else:
#         memo[i] = memo[i - 1] + 1
