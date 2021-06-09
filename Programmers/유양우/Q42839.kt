import java.lang.StringBuilder
import kotlin.math.sqrt

private var answer = 0
private var result = ArrayList<Int>()
fun main() {
    println(solutionv("17"))
}

fun solutionv(numbers: String): Int {
    var numberList = ArrayList<Int>()
    // numbers로 만들 수 있는 순열을 다 구하고 소수인지 체크하면 끝.
    numbers.forEach {
        numberList.add(it - '0')
    }

    for (i in 1..numberList.size) {
        permutation(numberList, 0, numberList.size, i)
    }
    result.distinct().forEach {
        if (decimal(it)) {
            answer++
        }
    }
    return answer
}

fun permutation(arr: ArrayList<Int>, depth: Int, n: Int, r: Int) {
    if (depth == r) {
        print(arr, r)
        return
    }
    for (i in depth until n) {
        swap(arr, depth, i)
        permutation(arr, depth + 1, n, r)
        swap(arr, depth, i)
    }
}

fun swap(arr: ArrayList<Int>, depth: Int, i: Int) {
    val temp = arr[depth]
    arr[depth] = arr[i]
    arr[i] = temp
}

fun print(arr: ArrayList<Int>, r: Int) {
    var stringBuilder = StringBuilder()
    for (i in 0 until r) {
        stringBuilder.append(arr[i])
    }
    result.add(stringBuilder.toString().toInt())

}

fun decimal(list: Int): Boolean {
    println(list)
    when {
        list > 2 -> {
            for (i in 2..sqrt(list.toDouble()).toInt()) {
                if (list % i == 0) {
                    return false
                }
            }
        }
        list == 2 -> {
            return true
        }
        else -> return false
    }
    return true
}