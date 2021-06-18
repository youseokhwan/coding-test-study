import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.number


fun main() {
    print(solution("1231234", 3))
}

fun solution(number: String, k: Int): String {
    var answer = StringBuilder(number)
    var count = k
    var index = 1

    while(count > 0) {
        if(answer[index-1] < answer[index]) {
            answer.deleteCharAt(index-1)
            count--
            if(index!=1) {
                index--
            }
        }
        else {
            index++
        }
        if(index >= answer.length) {
            break
        }
    }
    if(answer.length > number.length - k) {
        for(j in answer.length-1 downTo number.length-k) {
            answer.deleteCharAt(j)
        }
    }
    return answer.toString()
}