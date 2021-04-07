import java.util.*

class Q1753Edge(var endNode: Int, var weight: Int) : Comparable<Q1753Edge> {
    override fun compareTo(other: Q1753Edge): Int {
        return this.weight - other.weight
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (v, e) = br.readLine().trim().split(" ").map { it.toInt() }
    val startV = br.readLine().trim().toInt()

    val dijkstraDistanceArr = IntArray(v + 1) { Integer.MAX_VALUE }
    val dijkstraInitArr: ArrayList<PriorityQueue<Q1753Edge>> = ArrayList(v + 1)
    val dijkstraVisitArr = BooleanArray(v + 1)

    for ( i in 0 until v+1 ) {
        dijkstraInitArr.add(PriorityQueue())
    }

    repeat(e) {
        val (a, b, c) = br.readLine().trim().split(" ").map { it.toInt() }
        dijkstraInitArr[a].add(Q1753Edge(b, c))
    }

    val pq: PriorityQueue<Q1753Edge> = PriorityQueue<Q1753Edge>()

    dijkstraDistanceArr[startV] = 0
    pq.add(Q1753Edge(startV, 0))

    while ( !pq.isEmpty() ) {
        val now: Int = pq.poll().endNode

        if (dijkstraVisitArr[now]) continue
        dijkstraVisitArr[now] = true

        for (node in dijkstraInitArr[now]) {
            if ( dijkstraDistanceArr[node.endNode] > dijkstraDistanceArr[now] + node.weight ) {
                dijkstraDistanceArr[node.endNode] = dijkstraDistanceArr[now] + node.weight
                pq.add(Q1753Edge(node.endNode, dijkstraDistanceArr[node.endNode]))
            }
        }
    }

    for ( i in 1 until v+1 ) {
        if (dijkstraDistanceArr[i] == Int.MAX_VALUE)
            bw.write("INF\n")
        else
            bw.write("${dijkstraDistanceArr[i]}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}