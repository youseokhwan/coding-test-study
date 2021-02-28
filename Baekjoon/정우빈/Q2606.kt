import java.util.*

fun main() {
    val comCount = readLine()!!.toInt()
    val netCount = readLine()!!.toInt()
    val start = 1
    var result = 0

    // n + 1 은 정점과 인덱스를 맞춰주기위해
    // BooleanArray 는 default가 false
    val visited = BooleanArray(comCount + 1)
    // 인접행렬 구현
    val netArr = Array(comCount + 1) { IntArray( comCount + 1 ) }
    repeat (netCount) {
        val netInfo = readLine()!!.split(" ")
        // 인접 노드 초기화
        netArr[netInfo[0].toInt()][netInfo[1].toInt()] = 1
        netArr[netInfo[1].toInt()][netInfo[0].toInt()] = 1
    }

    // BFS 구현
    val queue = LinkedList<Int>()
    // 탐색한 정점은 queue에 넣고 visited true 로 변경
    queue.offer(start)
    visited[start] = true

    while (!queue.isEmpty()) {
        val dq = queue.poll()
        for (i in 1 until comCount + 1) {
            // 현재 탐색한 정점과 연결된 정점 탐색
            if (netArr[dq][i] == 1 && !visited[i]) {
                queue.offer(i)
                visited[i] = true
                result++
            }
        }
    }
    print(result)
}