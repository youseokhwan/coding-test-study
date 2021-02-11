fun main () {
    val a = readLine()!!.toInt()

    if(a>=90) print("A");
    else if(a>=80) print("B");
    else if (a>=70) print("C");
    else if(a>=60) print("D");
    else print("F");

//    when(a) {
//        in 90..100 -> println("A")
//        in 80..89 -> println("B")
//        in 70..79 -> println("C")
//        in 60..69 -> println("D")
//        else -> println("F")
//    }
}