from sys import stdin

case = int(stdin.readline())
house_list = []

for i in range(case):
    rgb = [int(num) for num in input().split(' ')]
    house_list.append(rgb)

for i in range(1, len(house_list)):
    house_list[i][0] = min(house_list[i - 1][1], house_list[i - 1][2]) + house_list[i][0]  # Red
    house_list[i][1] = min(house_list[i - 1][0], house_list[i - 1][2]) + house_list[i][1]  # Green
    house_list[i][2] = min(house_list[i - 1][0], house_list[i - 1][1]) + house_list[i][2]  # Blue

print(min(house_list[case - 1][0], house_list[case - 1][1], house_list[case - 1][2]))
