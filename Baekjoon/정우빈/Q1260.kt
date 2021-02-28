import java.util.*

var n: Int = 0
var m: Int  = 0
var v: Int  = 0
var visited: BooleanArray = booleanArrayOf()
var lineArr: Array<IntArray> = arrayOf()

fun main() {
    val info = readLine()!!.split(" ").map { it.toInt() }
    n = info[0]
    m = info[1]
    v = info[2]

    // n + 1 은 정점과 인덱스를 맞춰주기위해
    // BooleanArray 는 default가 false
    visited = BooleanArray(n + 1)
    // 인접행렬 구현
    lineArr = Array(n + 1) { IntArray( n + 1 ) }
    repeat (m) {
        val lineInfo = readLine()!!.split(" ")
        // 인접 노드 초기화
        lineArr[lineInfo[0].toInt()][lineInfo[1].toInt()] = 1
        lineArr[lineInfo[1].toInt()][lineInfo[0].toInt()] = 1
    }

    dfs(v)
    for(i in visited.indices) {
        visited[i] = false
    }
    println()
    bfs(v)
}

fun dfs(index: Int) {
    // 탐색한 정점 visited true 로 변경
    visited[index] = true
    print("${index} ")
    for (i in 1 until n + 1) {
        // 현재 탐색한 정점과 인접한 정점이면 현재 함수 호출(재귀)
        if (lineArr[index][i] == 1 && !visited[i]) dfs(i)
    }

}

fun bfs(index: Int) {
    val queue = LinkedList<Int>()
    // 탐색한 정점은 queue에 넣고 visited true 로 변경
    queue.offer(index)
    visited[index] = true
    print("${index} ")

    while (!queue.isEmpty()) {
        val dq = queue.poll()
        for (i in 1 until n + 1) {
            // 현재 탐색한 정점과 인접한 정점 탐색
            if (lineArr[dq][i] == 1 && !visited[i]) {
                queue.offer(i)
                visited[i] = true
                print("${i} ")
            }
        }
    }
}
