from sys import stdin

n = int(stdin.readline())
n_list = [1, 2]

for i in range(2, n):
    number = n_list[i - 1] + n_list[i - 2]
    n_list.append(number % 15746)

print(n_list[n - 1])
