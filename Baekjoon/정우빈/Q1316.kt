// 97~122 a~z | -97 = -a  | -> 0~25

fun main () {
    val count = readLine()!!.toInt()
    var result = 0

    for (i in 0 until count) {
        if (checkFunc()) {
            result++
        }
    }

    print(result)
}

fun checkFunc(): Boolean {
    val check = BooleanArray(26)
    val str = readLine()!!
    var prev = 0

    for (j in str.indices) {
        val now = str[j].toInt()

        if (now != prev) {
            if (!check[now - 97]) {
                check[now - 97] = true
                prev = now
            }
            else {
                return false
            }
        }
    }
    return true
}