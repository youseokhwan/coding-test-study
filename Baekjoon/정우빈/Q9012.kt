import java.util.*

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
    val stack = Stack<Char>()
    str.forEach {
        if (it == '(') {
            stack.push(it)
        }
        else {
            if (stack.isEmpty()) {
                return "NO"
            }
            else {
                stack.pop()
            }
        }
    }
    return if (stack.isEmpty()) {
        "YES"
    }
    else {
        "NO"
    }
}