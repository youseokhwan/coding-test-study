import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val count = br.readLine().toInt()
    val strArr: Array<String> = Array(count) { "" }
    for (i in 0 until count) {
        strArr[i] = br.readLine().trim()
    }
    strArr.distinct()

    // comparator 반환이 양수값이면 자리 변
    val customComparator =  Comparator<String> { s1, s2 ->
        when {
            // compareTo : s1이 크면 양수, 그외에는 음수 반환
            (s1.length == s2.length) -> s1.compareTo(s2)
            else -> s1.length - s2.length
        }
    }

    strArr.sortWith(customComparator)

    bw.write("${strArr[0]}\n")
    for (i in 1 until strArr.size) {
        if (strArr[i] != strArr[i - 1]) bw.write("${strArr[i]}\n")
    }
    bw.flush()
    bw.close()
    br.close()
}