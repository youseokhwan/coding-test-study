// 최대중량 : 로프중량 * (count - i)
fun main() {
    // 입력할 로프 수
    val count = readLine()!!.toInt()
    // 로프중량을 입력받을 배열
    val weightArr = IntArray(count)
    // 최대중량
    var maxWeight = 0

    // 각 로프 중량을 입력받아 배열 초기화
    for (i in 0 until count) {
        weightArr[i] = readLine()!!.toInt()
    }
    // 배열 오름차순 정렬
    weightArr.sort()

    // 배열 크기만큼 loop
    for (i in weightArr.indices) {
        // 현재 로프 기준 최대중량 계산
        // 여러 로프 중 가장 작은 최대중량을 가진 로프 기준으로 최종 최대중량이 결정되므로
        // 현재 기준 로프보다 인덱스가 작은 로프들은 제외
        val nowWeight = weightArr[i] * (count - i)
        // maxWeight 보다 nowWeight 가 크면 maxWeight 변경
        if (maxWeight < nowWeight) {
            maxWeight = nowWeight
        }
    }

    print(maxWeight)
}