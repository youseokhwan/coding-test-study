def solution(genres, plays):
    dictionary = {}

    for i in range(len(genres)):
        genre = genres[i]
        play = plays[i]

        if genre in dictionary:
            dictionary[genre]["count"] += play
            dictionary[genre][i] = play
        else:
            dictionary[genre] = {"count": play, i: play}

    sorted_keys = sorted(dictionary.keys(), key=lambda x: dictionary[x]["count"], reverse=True)
    answer = []

    for key in sorted_keys:
        sorted_value_keys = sorted(dictionary[key].keys(), key=lambda x: dictionary[key][x], reverse=True)
        end = 3
        if len(sorted_value_keys) == 2:
            end = 2
        for i in range(1, end):
            answer.append(sorted_value_keys[i])

    return answer


"""
{
    "classic" : {
        "count" : 1450,
        0 : 500,
        2 : 150,
        3 : 800
    },
    "pop" : {
        "count" : 3100,
        1 : 600,
        4 : 2500
    }
}
"""

print(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))
