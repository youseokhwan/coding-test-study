package `8진수 2진수- 1212번`

import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()){
    var N = readLine().toString()
    var cnt = 0.0
    var sum = 0.0
    for(i in N.length-1..0) {
        sum +=((N[i] - '0') * 8.0.pow(cnt))
        cnt+=1.0
    } // 십진수로 만듬.
    print(sum)

}