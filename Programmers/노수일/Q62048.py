import math


def solution(w, h):
    factor = math.gcd(w, h)

    answer = w * h - factor * (w // factor + h // factor - 1)
    return answer


print(solution(8, 12))
print(solution(5, 5))
print(solution(2, 4))
