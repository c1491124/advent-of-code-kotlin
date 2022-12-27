fun main() {
    val list = listOf(1,2,3,4,5,6,7,8)
    for (i in list.indices step 4) println(list[i+3])
}