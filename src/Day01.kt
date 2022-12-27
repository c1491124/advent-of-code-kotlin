fun main() {
    val list = mutableListOf<Int>()
    fun part1(input: List<String>): Int {
        var totalCalories = 0
        for (calories in input) {
            if (calories != "") {
                totalCalories += calories.toInt()
            } else {
                list.add(totalCalories)
                totalCalories = 0
            }
        }
        return list.max()
    }

    fun part2(): Int {
        list.sortDescending().let {
            var sum = 0
            for (i in 0..2) {
                sum += list[i]
            }
            return sum
        }
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2().println()

}
