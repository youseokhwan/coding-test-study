fun main () {
    // 항상 1000 미만의 숫자가 들어오고 거스름돈을 계산하는 문제
    var change = 1000 - readLine()!!.toInt()
    var count = 0

    // 주석과 같은 방식으로 짰지만 change 가 0 이 되었을 때에도 그 이후 연산을 해야하므로 비효율적이라고 생각되어 수정
//    count += change / 500
//    change %= 500

    // 배열에 거스름돈 단위
    val unit = intArrayOf(500, 100, 50, 10, 5, 1)

    // 배열을 하나씩 돌며 잔돈갯수와 남은 잔돈 계산
    for (i in unit.indices) {
        // (나눈 몫 = 사용할 동전 수) 가 0이 아니면 연산
        if (change / unit[i] > 0) {
            count += change / unit[i]
            change %= unit[i]

            // 남은 잔돈이 0이면 break
            if (change == 0) {
                break;
            }
        }
    }

    print(count)
}