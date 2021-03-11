fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val size = br.readLine().toInt()
    val arr = IntArray(10001)

    repeat (size) {
        arr[br.readLine().toInt()]++
    }

    for (i in arr.indices) {
//        if (arr[i] > 0) {
//            for (j in 0 until arr[i]) {
                bw.write("${i}\n".repeat(arr[i]))
//            }
//        }
    }

    br.close()
    bw.close()
}