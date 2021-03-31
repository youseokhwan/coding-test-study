import kotlin.math.max

// 연속된 칸 못감 -> 1칸 + 3칸전 vs 2칸전?
// 초기화 배열
lateinit var q2579InitArr: Array<Int>
// 결과 배열
lateinit var q2579ResultArr: Array<Int>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val count = br.readLine().trim().toInt()
    // 배열 크기를 count + 1 로 해야함
    // count로 할 경우 ArrayIndexOutOfBoundsException, 이미 첫칸을 밟고 있으므로 안됨
    q2579InitArr = Array(count + 1) { 0 }
    q2579ResultArr = Array(count + 1) { 0 }

    for (i in 1..count) {
        q2579InitArr[i] = br.readLine().trim().toInt()
    }

    q2579ResultArr[1] = q2579InitArr[1]
    if (count >= 2) q2579ResultArr[2] = q2579InitArr[1] + q2579InitArr[2]

    bw.write("${q2579Func(count)}")
    bw.flush()
    bw.close()
    br.close()
}

fun q2579Func(index: Int): Int {
    // index 0 일 때에는 더 이상 재귀호출 해줄 필요가 없음
    if (q2579ResultArr[index] == 0 && index != 0) {
        q2579ResultArr[index] = max(q2579Func(index - 2), q2579Func(index - 3) + q2579InitArr[index - 1]) + q2579InitArr[index]
    }
    return q2579ResultArr[index]
}