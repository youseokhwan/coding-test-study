fun main () {
    val str1 = readLine()!!
    val str2 = readLine()!!
    val check = IntArray(26)

    for (i in str1.indices) {
        check[str1[i].toInt() - 97]++
    }

    for (i in str2.indices) {
        check[str2[i].toInt() - 97]--
    }

    print(check.sumBy { if ( it >= 0 ) it else -it })

}