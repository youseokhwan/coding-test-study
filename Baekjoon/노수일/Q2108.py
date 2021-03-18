from sys import stdin

n = int(stdin.readline())

_sum = 0
# 계수 리스트 -4000 <= x <= 4000
_count_arr = [0] * 8001
_sorted_arr = []

for _ in range(0, n):
    _input_num = int(stdin.readline())
    # 산술평균을 위해 전체합을 구함
    _sum += _input_num
    # 숫자 + 4000의 계수 인덱스를 증가
    _count_arr[_input_num + 4000] += 1

# 최빈값들을 담기 위한 리스트
_frequent_arr = []

for i in range(8001):
    # 계수만큼 반복하여
    for j in range(_count_arr[i]):
        # 정렬될 리스트에 추가
        _sorted_arr.append(i - 4000)

    # 계수의 값이 최대값이라면 최빈값
    # 최빈값 리스트에 집어넣음
    # 계수순으로 넣기 때문에 최빈값 리스트는 따로 정렬이 필요없음
    if _count_arr[i] == max(_count_arr):
        _frequent_arr.append(i - 4000)

result = ""
result += str(round(_sum / n)) + '\n'  # 산술평균 -> 전체합 / N
result += str(_sorted_arr[int(n // 2)]) + '\n'  # 중앙값 -> 정렬된 리스트[N/2]
# 최빈값 -> 1개 이상이면 두번째로 작은수
result += str(_frequent_arr[0] if len(_frequent_arr) == 1 else _frequent_arr[1]) + '\n'

# 범위 -> 최대값 - 최소값 의 절대값
_range = _sorted_arr[0] - _sorted_arr[n - 1]
if _range < 0:
    _range = _range * -1
result += str(_range) + '\n'
print(result)
