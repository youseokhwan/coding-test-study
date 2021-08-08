from sys import stdin

n = int(stdin.readline())
consults = []
max_count = 0
memo = []

for i in range(n):
    consult_info = stdin.readline().split(' ')
    consults.append((int(consult_info[0]), int(consult_info[1])))
    memo.append(0)
memo.append(0)

for i in range(n):
    now = consults[i]
    max_count = max(max_count, memo[i])
    if i + now[0] > n:
        continue
    memo[i + now[0]] = max(memo[i + now[0]], max_count + now[1])

print(memo)
print(max(memo))
