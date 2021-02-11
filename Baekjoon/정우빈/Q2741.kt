fun main () {
    val a = readLine()!!.toInt()
    val str = StringBuilder()
    for(i in 1..a) {
        str.append(i).append("\n")
    }
    print(str)
}