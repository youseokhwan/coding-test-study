def solution(numbers, hand):
    def distance(finger, num):
        key_pad = [[1, 2, 3], [4, 5, 6], [7, 8, 9], ['*', 0, '#']]
        finger_index = [(i, j) for i in range(4) for j in range(3) if key_pad[i][j] == finger][0]
        num_index = [(i, j) for i in range(4) for j in range(3) if key_pad[i][j] == num][0]

        y_dist = finger_index[0] - num_index[0]
        x_dist = finger_index[1] - num_index[1]
        if x_dist < 0:
            x_dist = x_dist * -1
        if y_dist < 0:
            y_dist = y_dist * -1

        return x_dist + y_dist

    left, right = '*', '#'
    answer = ''

    for number in numbers:
        if number == 0 or number % 3 == 2:
            if distance(left, number) == distance(right, number):
                if hand == 'right':
                    answer += 'R'
                    right = number
                else:
                    answer += 'L'
                    left = number
            else:
                if distance(left, number) > distance(right, number):
                    answer += 'R'
                    right = number
                else:
                    answer += 'L'
                    left = number

        elif number % 3 == 1:
            answer += 'L'
            left = number
        else:
            answer += 'R'
            right = number

    return answer


print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right'))
print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], 'left'))
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], 'right'))
