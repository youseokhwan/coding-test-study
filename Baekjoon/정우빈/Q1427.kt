fun main() {
    val num = readLine()!!.toCharArray()
    num.sortDescending()
    val result = StringBuilder()
    for (a in num) {
        result.append(a)
    }
    print(result)
}