fun main() {
    val input = readInput("Day02")
    var sum = 0
    var sum2 = 0
    input.forEach {
        sum += part1(it[0].toString(), it[2].toString())
        sum2 += part2(it[0].toString(), it[2].toString())
    }
    sum.println()  //14297
    sum2.println()  //10498

}

fun shapeScoreFun(input: String) = when (input) {
    "X" -> 1
    "Y" -> 2
    "Z" -> 3
    else -> throw Exception("wrong input")
}

fun part1(opponent: String, my: String): Int {
    val shapeScore = shapeScoreFun(my)
    var outComeScore = 0  // lost
    if (opponent.single() - my.single() == -23) outComeScore = 3  //draw
    if ((opponent == "A" && my == "Y") ||
        (opponent == "B" && my == "Z") ||
        (opponent == "C" && my == "X")
    ) {
        outComeScore = 6 // win
    }
    return shapeScore + outComeScore
}

fun part2(opponent: String, outcome: String): Int {
    var my = "X" // rock for input of shapeScoreFun
    val outcomeScore = when (outcome) {
        "X" -> 0    // lose
        "Y" -> 3    // draw
        "Z" -> 6    // win
        else -> throw Exception("wrong input")
    }
    // case for my = "Y" paper
    if ((opponent == "A" && outcomeScore == 6) ||
        (opponent == "B" && outcomeScore == 3) ||
        (opponent == "C" && outcomeScore == 0)
    ) {
        my = "Y"
    }
    // case for my = "Z" Scissors
    if ((opponent == "A" && outcomeScore == 0) ||
        (opponent == "B" && outcomeScore == 6) ||
        (opponent == "C" && outcomeScore == 3)
    ) {
        my = "Z"
    }
    return shapeScoreFun(my) + outcomeScore
}

