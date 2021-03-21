fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val oldCount = br.readLine().trim().toInt()
    val oldNum = br.readLine().trim().split(" ").map { it.toInt() }
    val oldArr = IntArray(oldCount)
    for (i in 0 until oldCount) {
        oldArr[i] = oldNum[i]
    }
    oldArr.sort()

    val newCount = br.readLine().trim().toInt()
    val newNum = br.readLine().trim().split(" ")
    for (i in 0 until newCount) {
        bw.write("${binarySearch(oldArr, newNum[i].toInt())}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}

fun binarySearch(oldArr: IntArray, num: Int): Int {
    var start = 0
    var end = oldArr.size - 1
    var mid: Int = (start + end) / 2

    while ((end - start) >= 0) {
        if (num == oldArr[mid]) return 1
        else if (num > oldArr[mid]) start = mid + 1
        else end = mid - 1

        mid = (start + end) / 2
    }

    return 0
}