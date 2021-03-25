// 메모이제이션
val fiboArr = Array(41) { Array(2) { -1 } }
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    // 피보나치 0, 1일 때 0, 1 호출 횟수 초기화
    fiboArr[0][0] = 1
    fiboArr[0][1] = 0
    fiboArr[1][0] = 0
    fiboArr[1][1] = 1

    val count = br.readLine().trim().toInt()

    repeat(count) {
        val num = br.readLine().trim().toInt()
        fibonacci(num)
        bw.write("${fiboArr[num][0]} ${fiboArr[num][1]}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}

// a 에 대한 피보나치, 리턴값 : a의 0,1 호출 횟수
fun fibonacci(a: Int): Array<Int> {
    if (fiboArr[a][0] == -1 || fiboArr[a][1] == -1) {
        fiboArr[a][0] = fibonacci(a - 1)[0] + fibonacci(a - 2)[0]
        fiboArr[a][1] = fibonacci(a - 1)[1] + fibonacci(a - 2)[1]
    }
    return fiboArr[a]
}