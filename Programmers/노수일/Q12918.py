import re


def solution(s):
    if len(s) != 4 and len(s) != 6:
        return False

    if re.match(r'^[0-9]+$', s):
        return True

    return False


print(solution("a234"))
print(solution("1234"))
