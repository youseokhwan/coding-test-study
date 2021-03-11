fun main() {
    val size = readLine()!!.toInt()
    val arr = ArrayList<Int>(size)
    val result = StringBuilder()

    repeat (size) {
        arr.add(readLine()!!.toInt())
    }

    arr.sort()
    arr.forEach { result.append("${it}\n") }

    print(result)
}