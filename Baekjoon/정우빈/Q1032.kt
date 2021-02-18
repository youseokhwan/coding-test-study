fun main() {
    val count = readLine()!!.toInt()
    val output = StringBuilder(readLine()!!)
    val length = output.length
    val strArr = ArrayList<String>(count)

    for (i in 0 until count - 1) {
        strArr.add(readLine()!!)
    }

    for (i in 0 until length) {
        for (j in 0 until count - 1) {
            if (output[i] != strArr[j][i]) {
                output[i] = '?'
                break
            }
            continue
        }
    }

    print(output)
}