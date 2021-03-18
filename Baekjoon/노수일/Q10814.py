from sys import stdin

n = int(stdin.readline())
"""
key : 나이
value : 이름 리스트 

{
    21 : ['Junkyu', 'Dohyun'],
    20 : ['Sunyoung']
}
"""
_age_list, _user_dict = [], {}
for _ in range(0, n):
    _line = str(input()).split(' ')
    _age = int(_line[0])
    _name = str(_line[1])
    # key 값이 있으면 value list 에 append
    if _age in _user_dict:
        _user_dict[_age].append(_name)
    else:
        # key 값이 없으면 value list 를 만듬
        _user_dict[_age] = [_name]
        _age_list.append(_age)

# 나이 리스트 정렬
_age_list.sort()

result = ''
for _age in _age_list:
    _name_list = _user_dict[_age]
    for _name in _name_list:
        result += str(_age) + ' ' + str(_name) + '\n'

print(result)
