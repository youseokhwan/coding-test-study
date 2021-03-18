from sys import stdin


def binary_search(number_list: list, number: int) -> int:
    """
    이진 탐색
    :param number_list: 탐색이 수행될 list
    :param number: 탐색되길 원하는 숫자
    :return: 1(True) or 0(False)
    """

    def contains_number(start: int, end: int) -> int:
        """
        start 와 end 인덱스 사이에 number 가 존재하는지 판단하는 함수
        :param start: 시작
        :param end: 끝
        :return: 1(True) or 0(False)
        """
        # 시작 인덱스가 종료 인덱스를 넘어가면 없다고 판단하고 탐색 종료
        if start > end:
            return 0
        # 가운데숫자를 우선 비교
        _mid = (start + end) // 2
        if _number_list[_mid] == number:  # mid 와 일치하면 1
            return 1
        elif _number_list[_mid] > number:  # mid 보다 작으면 start 부터 mid 이전까지 탐색
            return contains_number(start, _mid - 1)
        else:  # mid 보다 크면 mid + 1 부터 end 탐색
            return contains_number(_mid + 1, end)

    return contains_number(0, len(number_list) - 1)


_list_size = int(stdin.readline())
_number_list = [int(num) for num in stdin.readline().split(' ')]
_x_size = int(stdin.readline())
_x_list = [int(num) for num in stdin.readline().split(' ')]

_number_list.sort()
_result = ''
for x in _x_list:
    _result += str(binary_search(_number_list, x)) + '\n'

print(_result)
