// 내 풀이 : arr[n] = arr[n - 2] + arr[n - 3]
// 파도반 수열 : arr[n] = arr[n - 1] + arr[n - 5]
val q9461Arr = Array<Long>(101) { -1 }
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    q9461Arr[1] = 1L
    q9461Arr[2] = 1L
    q9461Arr[3] = 1L
    q9461Arr[4] = 2L
    q9461Arr[5] = 2L
    q9461Arr[6] = 3L
    q9461Arr[7] = 4L
    q9461Arr[8] = 5L
    q9461Arr[9] = 7L
    q9461Arr[10] = 9L

    val count = br.readLine().trim().toInt()
    repeat(count) {
        bw.write("${q9461Func(br.readLine().trim().toInt())}\n")
        bw.flush()
    }

    bw.close()
    br.close()
}

fun q9461Func(num: Int): Long {
    if (num in 1..10) return q9461Arr[num]
    else if (q9461Arr[num] == -1L) q9461Arr[num] = q9461Func(num - 1) + q9461Func(num - 5)

    return q9461Arr[num]
}