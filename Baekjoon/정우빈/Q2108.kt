import java.util.*
import kotlin.math.roundToInt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    // 절댓값이 4000을 넘지않음
    // 최빈값
    val arr = IntArray(8001)
    // 범위
    var min = 4001
    var max = -4001
    // 산술평균
    var sum = 0

    val count = br.readLine()!!.trim().toInt()
    val countArr = IntArray(count)

    for (i in countArr.indices) {
        val num = br.readLine()!!.trim().toInt()
        if (min > num) min = num
        if (max < num) max = num
        sum += num
        arr[num + 4000]++
        countArr[i] = num
    }

    // 최빈값
    var freq = 0
    for (i in arr.indices) {
        if (arr[i] > 0) {
            if (arr[i] > freq) {
                freq = arr[i]
            }
        }
    }
    val stack = Stack<Int>()
    var stackCount = 0
    for (i in arr.indices) {
        if (arr[i] > 0) {
            if (arr[i] == freq) {
                stack.push(i - 4000)
                stackCount++
                if (stackCount == 2) break
            }
        }
    }

    // 산술평균
    bw.write("${(((sum.toFloat() / count.toFloat())).roundToInt())}\n")
    countArr.sort()
    // 중앙값
    bw.write("${countArr[count / 2]}\n")
    // 최빈값
    bw.write("${stack.pop()}\n")
    // 범위
    bw.write("${max - min}")

    bw.flush()
    bw.close()
    br.close()

}