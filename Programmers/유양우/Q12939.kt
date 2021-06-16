fun main() {
    print(solutionq("1 2 3 4"))
}

fun solutionq(s: String): String {
    var answer = ""
    var array = ArrayList<Int>()
    var stringBuilder = StringBuilder()
    for (i in s.indices) {
        if (s[i] == ' ') {
            array.add(stringBuilder.toString().toInt())
            stringBuilder.delete(0, stringBuilder.length)
        } else {
            stringBuilder.append(s[i])
        }
    }
    array.add(stringBuilder.toString().toInt())
    array.sort()
    answer += array[0]
    answer += ' '
    answer += array[array.size - 1]
    return answer
}