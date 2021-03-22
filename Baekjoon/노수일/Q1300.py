from sys import stdin

n = int(stdin.readline())
k = int(stdin.readline())

start, end, result = 1, k, 0

while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in range(1, n + 1):
        count += min(mid // i, n)

    if count < k:
        start = mid + 1
    else:
        result = mid
        end = mid - 1

print(result)
