import kotlin.math.min
// 10만들기?
// 2,3으로 나누는 경우
// 1을 빼는건 카운트에 나머지를 더하는것과 같음
// 10 -> 2 * 5(2 * 2 + 1, 3 * 1 + 2 * 1), 3 * 3 + 1
// 11 -> 2 * 5 + 1, 3 * 3 + 2
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    bw.write("${q1463Func(br.readLine().trim().toInt(), 0)}")
    bw.flush()
    bw.close()
    br.close()
}

fun q1463Func(num: Int, count: Int): Int {
    if (num < 2) return count
    return min(q1463Func(num / 2, count + 1 + (num % 2)), q1463Func(num / 3, count + 1 + (num % 3)))
}
// 10일때
// 5, 1     2, 3        1, 4
//                      0, 6
//          1, 4
// 3, 2     1, 4
//          1, 3
