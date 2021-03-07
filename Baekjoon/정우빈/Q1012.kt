fun main() {
    val testCaseCount = readLine()!!.toInt()
    // 3차원 배열 선언
    val map = mutableListOf<Array<IntArray>>()
    // x, y 4방향 배열
    val xDirect = intArrayOf(1, -1, 0, 0)
    val yDirect = intArrayOf(0, 0, -1, 1)
    val resultArr = mutableListOf<Int>()

    // 지도 초기화
    for (i in 0 until testCaseCount) {
        val (M, N, K) = readLine()!!.split(" ").map { it.toInt() }
        map.add(Array(M) { IntArray(N) })
        for (j in 0 until K) {
            val (X, Y) = readLine()!!.split(" ").map { it.toInt() }
            map[i][X][Y] = 1
        }
    }

    // 지도 탐색
    for (i in 0 until testCaseCount) {
        var result = 0
        for (j in map[i].indices) {
            for (k in map[i][j].indices) {
                // 방문하지 않았고 배추가 있는 인덱스라면
                if (map[i][j][k] == 1) {
                    result++
                    dfs(i, j, k, map, xDirect, yDirect)
                }
            }
        }
        // 하나의 testCase 가 끝나면 필요한 벌레 수 add
        resultArr.add(result)
    }

    for (i in resultArr.indices) {
        println(resultArr[i])
    }

}

// dfs
fun dfs(i:Int, j:Int, k:Int, map: MutableList<Array<IntArray>>, xDirect: IntArray, yDirect: IntArray) {
    map[i][j][k] = 0

    // 4 방향 탐색(우 좌 하 상)
    for (a in 0 until 4) {
        val jSide = j + xDirect[a]
        val kSide = k + yDirect[a]

        // 탐색하려는 좌표가 맵 안쪽이면
        if (jSide in map[i].indices && kSide in map[i][j].indices) {
            // 좌표에 배추가 있고 방문하지 않았다면
            if (map[i][jSide][kSide] == 1) {
                // dfs 재귀호출
                dfs(i, jSide, kSide, map, xDirect, yDirect)
            }
        }
    }
}