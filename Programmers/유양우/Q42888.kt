fun main() {
print(solutionzx(arrayOf(
    "Enter uid1234 Muzi",
    "Enter uid4567 Prodo",
    "Leave uid1234",
    "Enter uid1234 Prodo",
    "Change uid4567 Ryan")))
}
fun solutionzx(record: Array<String>): ArrayList<String> {
    var answer = arrayListOf<String>()
    var pairList = ArrayList<Pair<String, String>>()
    var list = ArrayList<String>()
    var hashmap: HashMap<String, String> = HashMap()
    record.forEach {
       when(it.split(" ").first()) {
           "Enter" -> {
               hashmap[it.split(" ").component2()] = it.split(" ").component3()
           }
           "Leave" -> {

           }
           "Change" -> {
               hashmap[it.split(" ").component2()] = it.split(" ").component3()
           }
       }
    }
    record.forEach {
        when(it.split(" ").first()) {
            "Enter" -> {
                for(i in 0 until hashmap.size) {
                    if(hashmap.containsKey(it.split(" ").component2())) {
                        answer.add(hashmap[it.split(" ").component2()]+ "님이 들어왔습니다.")
                        break
                    }
                }
            }
            "Leave" -> {
                for(i in 0 until hashmap.size) {
                    if(hashmap.containsKey(it.split(" ").component2())) {
                        answer.add(hashmap[it.split(" ").component2()]+ "님이 나갔습니다.")
                        break
                    }
                }
            }
        }
    }

    return answer
}