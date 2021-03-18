from sys import stdin

_input_num = stdin.readline()
_numbers = []

# 문자열 내 문자단위로 반복
for num in _input_num:
    # 개행문자 continue
    if num == '\n':
        continue
    _numbers.append(int(num))

# 역순으로 정렬
_numbers.sort(reverse=True)
# 합쳐서 출력
print(''.join(str(num) for num in _numbers))
