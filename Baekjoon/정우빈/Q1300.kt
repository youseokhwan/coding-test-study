// 찾는 수 : 6    작은 수의 갯수
//1  2  3  4        6/1 > 4 -> 4
//2  4  6  8        6/2 < 4 -> 3
//3  6  9 12        6/3 < 4 -> 2
//4  8 12 16        6/4 < 4 -> 1      -> 4+3+2+1 = 10


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val arrSize = br.readLine().trim().toInt()
    val find = br.readLine().trim().toInt()

    var min = 1
    var max = find
    var mid: Int
    var result = 0

    while (min <= max) {
        mid = (min + max) / 2
        var count = 0

        for (i in 1..arrSize) {
            count += if ((mid / i) < arrSize) mid / i else arrSize
        }

        if (count < find) min = mid + 1
        else {
            result = mid
            max = mid - 1
        }
    }

    bw.write("${result}")
    bw.flush()
    bw.close()
    br.close()
}