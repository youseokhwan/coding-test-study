import java.util.*


fun main() {
    solution(2, 10, intArrayOf(7, 4, 5, 6))
}

fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    // bridge_lenth 다리에 올라갈 수 있는 트럭 수
    // weight 다리가 견딜 수 있는 무게
    // truck_weights 트럭별 무게
    var time = 0
    var waitQueue: Queue<Int> = LinkedList<Int>() // 대기중인 트럭
    var bridgeQueue: Queue<Int> = LinkedList<Int>() // 다리위에 있는 트럭
    truck_weights.forEach {
        waitQueue.add(it)
    }
    for (i in 0 until bridge_length) {
        bridgeQueue.add(0)
    }
    while (bridgeQueue.isNotEmpty()) {
        time++
        bridgeQueue.poll()
        if (waitQueue.isNotEmpty()) {
            if (bridgeQueue.sum() + waitQueue.peek() <= weight) {
                bridgeQueue.add(waitQueue.poll())
            } else {
                bridgeQueue.add(0)
            }
        }
    }

    print(time)

    return time
}
