// 개수 1 2 3 5 8 13 ...
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val num = br.readLine().trim().toInt()
    val arr = IntArray(num + 2) // 계산하기 쉽게 0과 num
    arr[1] = 1
    arr[2] = 2

    for (i in 3..num) {
        arr[i] = (arr[i - 1] + arr[i - 2]) % 15746
    }

    bw.write("${arr[num]}")
    bw.flush()
    bw.close()
    br.close()
}

val q1904Arr = Array(1000001) { -1 }
fun main2() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    q1904Arr[0] = 0
    q1904Arr[1] = 1
    q1904Arr[2] = 2

    bw.write("${q1904Func(br.readLine().trim().toInt())}")
    bw.flush()
    bw.close()
    br.close()
}

fun q1904Func(num: Int): Int {
    if (q1904Arr[num] == -1) q1904Arr[num] = (q1904Func(num - 1) + q1904Func(num - 2)) % 15746

    return q1904Arr[num]
}