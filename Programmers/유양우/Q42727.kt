import java.util.*

fun main() {
    print(solutionzx(intArrayOf(6,5,3,1,0)))
}
fun solutionzx(citations: IntArray): Int {
    citations.sortDescending()
    // 6 5 3 1 0
    for(i in citations.indices) {
        if(citations[i] <= i) {
          return i
        }
    }
    return citations.size
}