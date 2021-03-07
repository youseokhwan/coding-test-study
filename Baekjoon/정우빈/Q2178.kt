import java.util.*

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }
    // 각 칸으로 도달할 수 있는 칸 수 저장할 배열
    val path = Array(N) { IntArray(M) }
    // x, y 4방향 배열
    val xDirect = intArrayOf(1, -1, 0, 0)
    val yDirect = intArrayOf(0, 0, -1, 1)

    // 지도 초기화
    for (i in 0 until N) {
        val info = readLine()!!
        for (j in 0 until M) {
            map[i][j] = info[j].toInt() - 48
        }
    }

    // x, y 좌표 담는 큐
    val queue = LinkedList<Pair<Int, Int>>()
    // 처음 시작점 1
    path[0][0] = 1
    queue.offer(Pair(0, 0))

    bfs(queue, N, M, xDirect, yDirect, path, map)

    print(path[N-1][M-1])
}

// bfs
fun bfs(queue: LinkedList<Pair<Int, Int>>, N: Int, M: Int, xDirect: IntArray, yDirect: IntArray, path: Array<IntArray>, map: Array<IntArray>) {
    while (!queue.isEmpty()) {
        // poll 하여 x, y 좌표 가져옴
        val (curX, curY) = queue.poll()
        // 인접한 경로 탐색을 위해
        for (i in 0 until 4) {
            val nxtX = curX + xDirect[i]
            val nxtY = curY + yDirect[i]

            // 맵 밖을 벗어나면 다음 loop
            if (nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= M) continue
            // 지나가지 않았고 갈 수 있는 경로이면
            if (path[nxtX][nxtY] == 0 && map[nxtX][nxtY] == 1) {
                path[nxtX][nxtY] = path[curX][curY] + 1
                // 도착지점에 도착하면 return
                if (nxtX == N-1 && nxtY == M-1) return
                queue.offer(Pair(nxtX, nxtY))
            }
        }
    }
}