fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (old, new) = br.readLine().trim().split(" ").map { it.toInt() }
    val oldArr = LongArray(old)
    for (i in 0 until old) {
        oldArr[i] = br.readLine().trim().toLong()
    }
    oldArr.sort()
    // 최소 1, 최대 oldArr[old - 1]
    var min: Long = 1
    var max: Long = oldArr[old - 1]
    var mid: Long

    while (min <= max) {
        mid = (min + max) / 2

        var count: Long = 0
        for (i in oldArr.indices) {
            // mid 로 만들 수 있는 최대 갯수 계산
            count += oldArr[i] / mid
        }

        // new 보다 크거나 같으면 최솟값을 증가시켜 다시 반복
        if (count >= new) min = mid + 1
        else max = mid - 1
    }
    bw.write("${max}")

    bw.flush()
    bw.close()
    br.close()
}