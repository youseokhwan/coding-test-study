from sys import stdin

_input_numbers = [int(num) for num in input().split(' ')]
_k, _n = _input_numbers[0], _input_numbers[1]
_numbers = []

for i in range(0, _k):
    _numbers.append(int(stdin.readline()))

_start, _end = 1, max(_numbers)

while _start <= _end:
    _length = (_start + _end) // 2
    _number_of_line = 0

    for number in _numbers:
        _number_of_line = _number_of_line + number // _length

    if _number_of_line >= _n:
        _start = _length + 1
    else:
        _end = _length - 1

print(_end)
