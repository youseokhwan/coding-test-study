import copy


def solution(key, lock):
    key_length = len(key)
    lock_length = len(lock)

    def xor(x, y):
        result = bool((x and not y) or (not x and y))
        if result:
            return 1
        return 0

    extend_list = [[0 for _ in range(key_length * 2 + lock_length)] for _ in range(key_length * 2 + lock_length)]

    for i in range(lock_length):
        for j in range(lock_length):
            extend_list[key_length + i][key_length + j] = lock[i][j]

    def check(dy, dx, copied_extend_list):
        for y in range(key_length):
            for x in range(key_length):
                copied_extend_list[y + dy][x + dx] = xor(copied_extend_list[y + dy][x + dx], key[y][x])

        for y in range(lock_length):
            for x in range(lock_length):
                if copied_extend_list[key_length + y][key_length + x] == 0:
                    return False
        return True

    def rotate_key(original_key):
        result = [[0] * key_length for _ in range(key_length)]
        for row in range(key_length):
            for col in range(key_length):
                result[col][key_length - 1 - row] = original_key[row][col]
        return result

    answer = False
    for _ in range(4):
        for i in range(key_length + lock_length):
            for j in range(key_length + lock_length):
                if check(i, j, copy.deepcopy(extend_list)):
                    return True
        key = rotate_key(key)

    return answer


print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))
print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 1], [1, 1, 1]]))
print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]]))
print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 1], [0, 0, 0]]))
print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 1], [1, 0, 0]]))
