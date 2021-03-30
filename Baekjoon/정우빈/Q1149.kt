import kotlin.math.min
// 각 집의 색 비용
lateinit var q1149CostArr: Array<Array<Int>>
// 누적 비용
lateinit var q1149Arr: Array<Array<Int>>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val count = br.readLine().trim().toInt()
    q1149CostArr = Array(count) { Array(3) { 0 } }
    q1149Arr = Array(count) { Array(3) { 0 } }

    // 각 집의 색 비용 초기화
    for (i in 0 until count) {
        val (a, b, c) = br.readLine().trim().split(" ").map { it.toInt() }
        // 0 : red, 1 : green, 2 : blue
        q1149CostArr[i][0] = a
        q1149CostArr[i][1] = b
        q1149CostArr[i][2] = c
    }

    // 첫번째 집 누적 비용 초기화
    q1149Arr[0][0] = q1149CostArr[0][0]
    q1149Arr[0][1] = q1149CostArr[0][1]
    q1149Arr[0][2] = q1149CostArr[0][2]

    // 3가지 색 중 최소비용 출력
    bw.write("${min(q1149Func(0, count - 1), min(q1149Func(1, count - 1), q1149Func(2, count - 1)))}")
    bw.flush()
    bw.close()
    br.close()
}

// 마지막 집의 색의 최솟값 구하는 함수
fun q1149Func(color: Int, index: Int): Int {
    if (q1149Arr[index][color] == 0) {
        when(color) {
            0 -> q1149Arr[index][color] = min(q1149Func(1, index - 1), q1149Func(2, index - 1)) + q1149CostArr[index][color]
            1 -> q1149Arr[index][color] = min(q1149Func(0, index - 1), q1149Func(2, index - 1)) + q1149CostArr[index][color]
            2 -> q1149Arr[index][color] = min(q1149Func(0, index - 1), q1149Func(1, index - 1)) + q1149CostArr[index][color]
        }
    }
    return q1149Arr[index][color]
}