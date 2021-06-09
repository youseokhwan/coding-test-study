import kotlin.math.max
import kotlin.math.min

fun main() {
    print(solutionx(8,1))
}

fun solutionx(brown: Int, yellow: Int): ArrayList<Int> {
    var answer = ArrayList<Int>()
    var yaksuList = ArrayList<Int>()
    var width = brown + yellow
    for(i in 1..width) {
        if(width%i==0) {
            yaksuList.add(i)
        }
    }

    for(i in yaksuList.indices) {
        if(i+1 != yaksuList.size){
        for(j in i until yaksuList.size) {
            if(yaksuList[i]* yaksuList[j] == width) {
             // 2랑6 3과4가 들어갈것이다.
                if((yaksuList[i]-2) * (yaksuList[j]-2)== yellow) {
                    answer.add(max(yaksuList[i],yaksuList[j]))
                    answer.add(min(yaksuList[i],yaksuList[j]))
                }
            }
        }
        }
    }
    answer.forEach { print(it) }
    return answer
}