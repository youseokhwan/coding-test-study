fun main () {
    val count = readLine()!!.toInt()
    val output = StringBuilder(readLine()!!)
    val length = output.length

    for (i in 0 until count-1) {
        val strNew = readLine()!!
        for (j in 0 until length) {
            if (output[j] != strNew[j]) {
                output[j] = '?'
            }
        }
    }
    print(output)
}