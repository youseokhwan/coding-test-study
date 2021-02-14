fun main() {
    val a = readLine()!!.toInt()
    val str = StringBuilder()
    val star = StringBuilder()

    for (i in 1..a) {
        star.append("*")
        str.append(star).append("\n")

//        str.append("*".repeat(i)).append("\n")
//        for(j in 1..i) {
//            print("*")
//        }
//        println()
    }
    println(str)
}