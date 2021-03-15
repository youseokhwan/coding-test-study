fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val count = br.readLine()!!.toInt()
    val pointArr = mutableListOf<Pair<Int, Int>>()

    repeat(count) {
        val pointInfo = br.readLine()!!.trim().split(" ")
        pointArr.add(Pair(pointInfo[0].toInt(), pointInfo[1].toInt()))
    }

    pointArr.sortWith(compareBy ({ it.first }, { it.second }))

    for (point in pointArr) {
        bw.write("${point.first} ${point.second}\n")
    }
    bw.flush()
    bw.close()
    br.close()
}