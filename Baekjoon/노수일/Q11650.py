from sys import stdin

n = int(stdin.readline())

"""
key : x 좌표 
value : y 좌표 list 

{
    3 : [ 3, -1, 1],
    1 : [ 3, -1, 1],
    2 : [ 3, -1, 1]
}
"""

_key_list, _input_dict = [], {}
for _ in range(0, n):
    _point_arr = [int(num) for num in stdin.readline().split(' ')]
    # key 값이 있으면 value list에 append
    if _point_arr[0] in _input_dict:
        _input_dict[_point_arr[0]].append(_point_arr[1])
    # 없으면 새로운 리스트로 저장
    else:
        _input_dict[_point_arr[0]] = [_point_arr[1]]
        # 키 리스트에도 저장
        _key_list.append(_point_arr[0])

# 키 리스트 정렬 후
_key_list.sort()

# dictionary 의 각 value list 정렬
for _key in _input_dict:
    _input_dict[_key].sort()

result = ''
# 순서대로 출력
for _key in _key_list:
    _value_list = _input_dict[_key]
    for value in _value_list:
        result += str(_key) + ' ' + str(value) + '\n'

print(result)
