// 대각선을 뺀 나머지 4 방향을 탐색해
var count = 0
fun main() {
    val size = readLine()!!.toInt()
    val map = Array(size) { IntArray(size) }
    val visited = Array(size) { BooleanArray(size) { false } }
    // x, y 4방향 배열
    val xDirect = intArrayOf(1, -1, 0, 0)
    val yDirect = intArrayOf(0, 0, -1, 1)
    // 각 단지 내의 집 수를 담을 배열
    val resultArr = mutableListOf<Int>()

    // 지도 초기화
    for (i in 0 until size) {
        val info = readLine()!!
        for (j in 0 until size) {
            // string 문자열을 하나씩 접근할때에는 char 형 -> 0 = 48
            map[i][j] = info[j].toInt() - 48
        }
    }

    // 지도 탐색
    for (i in 0 until size) {
        for (j in 0 until size) {
            // 방문하지 않았고 집이 있는 인덱스라면
            if (!visited[i][j] && map[i][j] == 1) {
                resultArr.add(dfs(i, j, map, visited, xDirect, yDirect))
                // 하나의 단지 탐색이 끝났으면 count = 0
                count = 0
            }
        }
    }

    // 오름차순 출력을 해야함
    resultArr.sort()

    // 단지 수
    println(resultArr.size)
    // 각 단지 당 집 수
    for (result in resultArr) {
        println(result)
    }
}

// dfs
// 매개변수가 너무 많나..? 이전 문제에서는 전역변수로 돌렸어서 한번 해봄
fun dfs(x:Int, y:Int, map: Array<IntArray>, visited: Array<BooleanArray>, xDirect: IntArray, yDirect: IntArray): Int {
    visited[x][y] = true
    // dfs 메소드를 호출할 때 마다 count 증가 (집 수)
    count++

    // 4 방향 탐색(우 좌 하 상)
    for (i in 0 until 4) {
        val xSide = x + xDirect[i]
        val ySide = y + yDirect[i]

        // 탐색하려는 좌표가 맵 안쪽이면
        if (xSide in map.indices && ySide in map.indices) {
            // 좌표에 집이 있고 방문하지 않았다면
            if (map[xSide][ySide] == 1 && !visited[xSide][ySide]) {
                // dfs 재귀호출
                dfs(xSide, ySide, map, visited, xDirect, yDirect)
            }
        }
    }
    // 집 수 return 하여 메인에서 resultArr 에 추가
    return count
}