fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val count = br.readLine()!!.toInt()
    val userArr = mutableListOf<Pair<Int, String>>()

    repeat(count) {
        val userInfo = br.readLine()!!.trim().split(" ")
        userArr.add(Pair(userInfo[0].toInt(), userInfo[1]))
    }

    userArr.sortWith(compareBy { it.first })
    for (user in userArr) {
        bw.write("${user.first} ${user.second}\n")
    }
    bw.flush()
    bw.close()
    br.close()
}