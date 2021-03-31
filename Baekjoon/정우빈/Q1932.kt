import kotlin.math.max

// 정수삼각형 초기화 배열
lateinit var q1932InitArr: Array<Array<Int>>
// 결과 배열
lateinit var q1932ResultArr: Array<Array<Int>>

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val count = br.readLine().trim().toInt()
    q1932InitArr = Array(count) { Array(count) { -1 } }
    q1932ResultArr = Array(count) { Array(count) { -1 } }

    for (i in 0 until count) {
        val info = br.readLine().trim().split(" ").map { it.toInt() }
        for (j in info.indices) {
            q1932InitArr[i][j] = info[j]
            // top-down 방식으로 마지막 결과배열에 값을 넣어준다
            if (i == count - 1) q1932ResultArr[i][j] = info[j]
        }
    }

    bw.write("${q1932Func(0, 0)}")
    bw.flush()
    bw.close()
    br.close()

}

fun q1932Func(deep: Int, index: Int): Int {
    // 값이 들어있지 않다면 해당 깊이의 아래의 자식노드에서 최댓값을 현재 값과 더함
    if (q1932ResultArr[deep][index] == -1) {
        q1932ResultArr[deep][index] = max(q1932Func(deep + 1, index), q1932Func(deep + 1, index + 1)) + q1932InitArr[deep][index]
    }
    return q1932ResultArr[deep][index]
}