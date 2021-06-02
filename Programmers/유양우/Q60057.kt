import java.lang.Exception
import java.lang.StringBuilder

fun main() {
    solutionxc("x")
}

fun solutionxc(s: String): Int {
    var answer = 0
    var str = ArrayList<String>()
    var strb = StringBuilder()
    var count = ArrayList<Int>()
    var before = ""

    if(s.length == 1) {
        return 1
    }
    else {
        // 우선 한개씩 짤라서 비교 a, aa, aab, aabb
        for (i in 0 until s.length / 2) { // 0 1 2 3 i = 2일 때
            var cnt = 1
            var over = StringBuilder() // 짜투리가 남으면 필요한 StringBuilder
            for (j in s.indices step (i + 1)) { // j는 0 3 6
                try {
                    if (j + i + i + 1 >= s.length) { // 길이가 길어서 짜투리가 남으면 over에 append
                        for (z in j + i + 1 until s.length) {
                            over.append(s[z])
                        }
                    }
                    before = s.slice(j..j + i) // 첫 번째로 잘라서 넣음
                    var later = s.slice(j + i + 1..j + i + i + 1) // 그 다음꺼 잘라서 넣음
                    if (before == later) { // 같으면 cnt++
                        cnt++
                    } else { // 같지 않을 때
                        if (cnt == 1) { // cnt가 1일 때 즉 같은게 하나도 없을 때는 그냥 append
                            strb.append(before)
                        } else { // cnt가 1이 아니면 cnt숫자와 before append
                            strb.append(cnt.toString() + before)

                        }
                        cnt = 1 // 다음꺼 비교를위해 cnt 1로 초기화
                    }
                } catch (e: Exception) {

                }
            }
            if (cnt == 1) { // cnt가 1일 때 즉 같은게 하나도 없을 때는 그냥 append
                strb.append(before)
            } else { // cnt가 1이 아니면 cnt숫자와 before append
                strb.append(cnt.toString() + before)

            }
            if (over.isNotEmpty()) { // 짜투리가 남아있으면 over append
                strb.append(over)
            }
            str.add(strb.toString()) // 배열에 완성된 문자열 추가
            strb.delete(0, strb.length) // StringBuilder 초기화
        }
    }
    str.forEach { // 배열 길이 count 배열에 삽입
        count.add(it.length)
    }
    count.sort() // 오름차순 정렬
    return count[0]
}