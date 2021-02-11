fun main() {
    val a = readLine()!!.toInt()
    val str = StringBuilder()

    for(i in 1..a) {
        str.append("*".repeat(i)).append("\n")
//        for(j in 1..i) {
//            print("*")
//        }
//        println()
    }
    println(str)
}