import java.util.*

fun main() {
    val count = readLine()!!.split(" ")
    // 보석 수
    val jewelryCount = count[0].toInt()
    // 가방 수
    val bagCount = count[1].toInt()
    // 최종 결과(보석 무게의 합)
    var result: Long = 0

    // 보석 정보 배열
    val jewelryArr = mutableListOf<Pair<Int, Int>>()
    // 보석 정보 배열 초기화
    for (i in 0 until jewelryCount) {
        val jewelryInfo = readLine()!!.split(" ")
        jewelryArr.add(Pair(jewelryInfo[0].toInt(), jewelryInfo[1].toInt()))
    }
    // 무게 오름차순 정렬, 같다면 가격 오름차순 정렬
    jewelryArr.sortWith(compareBy ({ it.first }, { it.second }))

    // 가방 정보 배열
    val bagArr = mutableListOf<Int>()
    // 가방 무게 배열 초기화
    for (i in 0 until bagCount) {
        bagArr.add(readLine()!!.toInt())
    }
    // 가방 오름차순 정렬
    bagArr.sort()

    // 우선순위 큐 - 우선순위 큰 순서
    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
    var jewelIndex = 0
    for (i in bagArr.indices) {
        // 가방 하나에 담을 수 있는 모든 보석 담아보는 loop
        for (j in jewelIndex until jewelryCount) {
            // 가방에 보석을 담지 못하면
            if (bagArr[i] < jewelryArr[j].first) break
            // 현재까지 담은 보석 index 저장
            jewelIndex++
            priorityQueue.offer(jewelryArr[j].second)
        }
        // 담을 수 있는 보석을 다 담은 후 우선순위 큐가 우선순위 큰 순이므로 peek 값을 result 에 더함
        if (!priorityQueue.isEmpty()) result += priorityQueue.poll()
    }

    print(result)
}