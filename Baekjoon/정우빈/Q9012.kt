// ( = push, ) = pop or false
// 괄호 남으면 false

fun main () {
    val count = readLine()!!.toInt()
    val result = StringBuilder()

    for (i in 0 until count) {
        val str = readLine()!!
        result.append(ex(str)).append("\n")
    }
    print(result)
}

fun ex(str: String): String {
    val stack = arrayListOf<Char>()
    str.forEach {
        if (it == '(') {
            stack.add(it)
            return@forEach
        }
        if (stack.isEmpty()) {
            return "NO"
        }
        stack.removeAt(stack.size-1)
    }
    return if (stack.isEmpty()) {
        "YES"
    } else {
        "NO"
    }
}