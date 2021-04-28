from sys import stdin

n = int(stdin.readline())
numbers = [int(num) for num in stdin.readline().split()]
memo = [0 for _ in range(n)]

for i in range(n):
    for j in range(i):
        if numbers[i] > numbers[j] and memo[j] > memo[i]:
            memo[i] = memo[j]
    memo[i] += 1

print(memo)
print(max(memo))

"""
8
50 60 30 10 30 20 40 50
 0  0  0  0  0  0  0  0
 1  0  0  0  0  0  0  0
 1  2  0  0  0  0  0  0
 1  2  1  0  0  0  0  0
 1  2  1  1  0  0  0  0
 1  2  1  1  2  0  0  0
 1  2  1  1  2  1  0  0
 1  2  1  1  2  2  0  0 
"""
