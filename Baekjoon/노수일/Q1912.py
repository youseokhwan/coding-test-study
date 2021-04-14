from sys import stdin

n = int(stdin.readline())
numbers = [int(num) for num in stdin.readline().split()]
tmp = [0 for _ in range(n + 1)]
max_number = -1001

for i in range(n):
    # 연속해서 더한값 vs 자기 자신 값
    tmp[i + 1] = max(tmp[i] + numbers[i], numbers[i])
    max_number = max(max_number, tmp[i + 1])

print(max_number)
