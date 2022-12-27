fun main() {
    //a~z = 97~122
    //A~Z = 65~90
    val input = readInput("Day03")
    /////////////////////  part 1   ///////////////////////////////////
    var sum = 0
    input.forEach {
        val (first, second) = it.chunked(it.length / 2)
        first.toSet()
            .intersect(second.toSet())
            .toCharArray()[0]
            .apply {
                sum += if (this.isLowerCase()) {
                    this.code - 96
                } else {
                    this.code - 38
                }
            }
    }
    sum.println()  // 8233

    ///////////////////////// part 2 ////////////////////////////////
    val setA = mutableSetOf<Char>()
    val setB = mutableSetOf<Char>()
    val setC = mutableSetOf<Char>()
    var count = 0
    var sum2 = 0
    input.forEach {
        when (count % 3) {
            0 -> setA += it.toSet()
            1 -> setB += it.toSet()
            2 -> setC += it.toSet()
            else -> throw Exception("error")
        }
        count += 1
        if (count % 3 == 0) {
            setA.intersect(setB).intersect(setC).toCharArray()[0].apply {
                sum2 +=
                    if (this.isLowerCase()) {
                        this.code - 96
                    } else {
                        this.code - 38
                    }
            }
            setA.clear()
            setB.clear()
            setC.clear()
        }
    }
    sum2.println()
}