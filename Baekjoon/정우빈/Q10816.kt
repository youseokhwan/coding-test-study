//fun main() {
//    val br = System.`in`.bufferedReader()
//    val bw = System.`out`.bufferedWriter()
//
//    val oldCount = br.readLine().trim().toInt()
//    val oldNum = br.readLine().trim().split(" ").map { it.toInt() }
//    val positiveArr = mutableListOf<Int>()
//    val negativeArr = mutableListOf<Int>()
//    oldNum.sorted()
//    for (i in 0 until oldCount) {
//        if (oldNum[i] < 0) {
//            negativeArr.add(oldNum[i])
//            continue
//        }
//        positiveArr.add(oldNum[i])
//    }
//
//    val newCount = br.readLine().trim().toInt()
//    val newNum = br.readLine().trim().split(" ").map { it.toInt() }
//    for (i in 0 until newCount) {
//        if (newNum[i] < 0) {
//            bw.write("${binarySearch2(negativeArr, newNum[i])} ")
//            continue
//        }
//        bw.write("${binarySearch2(positiveArr, newNum[i])} ")
//    }
//
//    bw.flush()
//    bw.close()
//    br.close()
//}
//
//fun binarySearch2(arr: MutableList<Int>, num: Int): Int {
//    var start = 0
//    var end = arr.size - 1
//    var mid: Int = (start + end) / 2
//    var result = 0
//
//    while ((end - start) >= 0) {
//        if (num == arr[mid]) result++
//        else if (num > arr[mid]) start = mid + 1
//        else end = mid - 1
//
//        mid = (start + end) / 2
//    }
//
//    return result
//}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val arr = IntArray(20000001)

    val oldCount = br.readLine().trim().toInt()
    val oldNum = br.readLine().trim().split(" ").map { arr[it.toInt() + 10000000]++ }

    val newCount = br.readLine().trim().toInt()
    val newNum = br.readLine().trim().split(" ").map { bw.write("${arr[it.toInt() + 10000000]} ")}

    bw.flush()
    bw.close()
    br.close()
}