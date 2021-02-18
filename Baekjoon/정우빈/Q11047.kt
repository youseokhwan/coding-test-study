fun main () {
    // map 으로 간편하게 하려했지만 시간이 오래걸림
//    var (n, k) = readLine()!!.split(" ").map { it.toInt() }

    val a = readLine()!!.split(" ")
    // n : 동전 수, k : 가치의 합
    val n = a[0].toInt()
    var k = a[1].toInt()
    // 동전 단위 저장하는 배열
    val unit = IntArray(n)
    // 사용한 동전 수
    var count = 0

    // 단위 저장배열 초기화
    for (i in 0 until n) {
        unit[i] = readLine()!!.toInt()
    }

    // 배열을 하나씩 돌며 사용한 동전 수와 남은 돈 계산
    // 오름차순으로 저장했으므로 downTo를 사용하여 인덱스 반대로 탐색
    for (i in n-1 downTo 0) {
        // (나눈 몫 = 사용할 동전 수) 가 0이 아니면 연산
        if (k / unit[i] > 0) {
            count += k / unit[i]
            k %= unit[i]

            // 남은 돈이 0이면 break
            if (k == 0) {
                break;
            }
        }
    }

    print(count)
}