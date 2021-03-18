from sys import stdin

n = int(stdin.readline())
counting_arr = [0]*10001

for _ in range(0, n):
    _number = int(stdin.readline())
    counting_arr[_number] += 1

for i in range(10001):
    for j in range(counting_arr[i]):
        print(i)
