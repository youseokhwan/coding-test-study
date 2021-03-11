from sys import stdin


def merge_sort(numbers: list) -> list:
    """
    머지 정렬
    :param numbers: 정렬할 list
    :return: 정렬된 list
    """

    # numbers 길이가 1보다 작으면 굳이 정렬을 할 필요가 없으므로
    if len(numbers) <= 1:
        return numbers

    def merge(left_numbers: list, right_numbers: list) -> list:
        """
        병합을 하면서 정렬을 하기 위한 함수
        :param left_numbers: 합칠 배열의 왼쪽 배열
        :param right_numbers: 합칠 배열의 오른쪽 배열
        :return: 병합된 리스트
        """

        _merged_list = []  # 병합하면서 정렬된 값을 담을 리스트
        _left, _right = 0, 0  # 왼쪽 배열, 오른쪽 배열의 초기 인덱스

        for i in range(0, len(left_numbers) + len(right_numbers)):
            # 두 리스트의 크기를 합친 만큼 반복

            if _left >= len(left_numbers):
                _merged_list.append(right_numbers[_right])
                _right = _right + 1
                continue

            if _right >= len(right_numbers):
                _merged_list.append(left_numbers[_left])
                _left = _left + 1
                continue

            # 왼쪽 배열의 값이 크면 왼쪽 배열의 값을 병합된 리스트에 담고 왼쪽 인덱스 + 1
            if left_numbers[_left] <= right_numbers[_right]:
                _merged_list.append(left_numbers[_left])
                _left = _left + 1
            # 오른쪽 배열의 값이 크면 오른쪽 배열의 값을 병합된 리스트에 담고 오른쪽 인덱스 + 1
            else:
                _merged_list.append(right_numbers[_right])
                _right = _right + 1
        return _merged_list

    _middle_index = len(numbers) // 2  # 초기에는 가운데를 중점

    _left_numbers = numbers[:_middle_index]  # 0<= index < _middle_index
    _right_numbers = numbers[_middle_index:]  # _middle_index<= index < len(numbers)

    _left_numbers = merge_sort(_left_numbers)
    _right_numbers = merge_sort(_right_numbers)

    return merge(left_numbers=_left_numbers, right_numbers=_right_numbers)


n = int(stdin.readline())
arr = []

for i in range(0, n):
    arr.append(int(stdin.readline()))

arr = merge_sort(arr)

for num in arr:
    print(num)
