// 메모이제이션
val arr = Array(21) { Array(21) { Array(21) { 0 } } }
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    while (true) {
        val (a, b, c) = br.readLine().trim().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) break
        bw.write("w($a, $b, $c) = ${w(a, b, c)}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}

fun w(a: Int, b: Int, c: Int): Int {
    if (a in 0..20 && b in 0..20 && c in 0..20 && arr[a][b][c] != 0) return arr[a][b][c]

    if (a <= 0 || b <= 0 || c <= 0) {
        arr[0][0][0] = 1
        return arr[0][0][0]
    } else if (a > 20 || b > 20 || c > 20) {
        arr[20][20][20] = w(20, 20, 20)
        return arr[20][20][20]
    } else if (a < b && b < c) {
        arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        return arr[a][b][c]
    } else {
        arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
        return arr[a][b][c]
    }
}