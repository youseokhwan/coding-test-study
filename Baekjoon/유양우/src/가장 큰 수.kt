import java.lang.StringBuilder

fun main() {
    print(solutionw(intArrayOf(5,4,3,7,8)))
}

fun solutionw(numbers: IntArray): String {
    var stringBuilder = StringBuilder()
    var stringArray = ArrayList<String>()
    numbers.forEach {
        stringArray.add(it.toString())
    }
    stringArray.sortedWith(Comparator<String> { o1, o2 ->
        (o2 + o1).compareTo(o1 + o2)
    }).forEach {
        stringBuilder.append(it)
    }
    if((stringBuilder.toString())[0] == '0') {
        return "0"
    }
return stringBuilder.toString()
}
