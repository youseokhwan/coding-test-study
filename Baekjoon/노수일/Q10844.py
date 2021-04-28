from sys import stdin

max_num = 1000000000

"0 1 2 3 4 5 6 7 8 9"
"10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98"

n = int(stdin.readline())
memo = [[0, 1, 1, 1, 1, 1, 1, 1, 1, 1]]

for i in range(1, n):
    memo.append([0, 0, 0, 0, 0, 0, 0, 0, 0, 0])

for i in range(1, n):
    for j in range(10):
        if j != 0 and j != 9:
            memo[i][j] = (memo[i - 1][j - 1] + memo[i - 1][j + 1]) % max_num
        elif j == 0:
            memo[i][j] = (memo[i - 1][j + 1]) % max_num
        elif j == 9:
            memo[i][j] = (memo[i - 1][j - 1]) % max_num

print(sum(memo[n - 1]) % max_num)
