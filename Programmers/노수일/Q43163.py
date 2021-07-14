from collections import deque


def solution(begin, target, words):
    if target not in words:
        return 0

    characters = set()
    for word in words:
        characters.update(list(word))
    characters = list(characters)
    queue = deque([(begin, 0, words)])

    answer = 100
    while queue:
        current, depth, now_words = queue.popleft()
        if current == target:
            answer = min(answer, depth)

        for i in range(len(current)):
            for j in range(len(characters)):
                if current[i] == characters[j]:
                    continue
                temp_word = current[:i] + characters[j] + current[i + 1:]
                for k in range(len(now_words)):
                    if now_words[k] == temp_word:
                        now_words[k] = False
                        queue.append((temp_word, depth + 1, now_words))

    if answer == 100:
        return 0
    return answer


print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))
