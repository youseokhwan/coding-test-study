from sys import stdin

n = int(stdin.readline())
"""
key : 문자열 길이
value : 문자열 set 

{
    4 : ['wont', 'more'],
    1 : ['i'],
    2 : ['no', 'it', 'im']
}
"""
_length_dict, _key_arr = {}, []
for _ in range(0, n):
    _string = str(input())
    _length = len(_string)

    # key 값이 있으면 value set 에 add
    if _length in _length_dict:
        _length_dict[_length].add(_string)
    else:
        # key 값이 없으면 value set 을 만들고 add
        _length_set = set()
        _length_set.add(_string)
        _length_dict[_length] = _length_set
        _key_arr.append(_length)

# key list 정렬
_key_arr.sort()
_result = ''

for key in _key_arr:
    # set 을 list 로 변경하여 정렬
    _value_list = list(_length_dict[key])
    _value_list.sort()
    for value in _value_list:
        _result += value + '\n'

print(_result)
