fun main() {
    val input = readInput("Day06")
    fun part1(input: List<String>) {
        val marker = input[0].windowed(4).first {
            it.toSet().size == 4
        } // windowedSequence() is not faster here
        println(input[0].indexOf(marker) + 4)
    }

    fun part2(input: List<String>) {
        val marker = input[0].windowed(14).first {
            it.toSet().size == 14
        } // windowedSequence() is not faster here
        println(input[0].indexOf(marker) + 14)
    }
    part1(input)
    part2(input)
}