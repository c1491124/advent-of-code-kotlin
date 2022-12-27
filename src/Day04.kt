fun main() {
    val input = readInput("Day04")
    val nums = input.flatMap { line ->
        line.split(",")
            .flatMap { component ->
                component.split("-").map { it.toInt() }
            }
    }

    fun part1(): Int {
        var sum = 0
        for (i in nums.indices step 4) {
            if (nums[i] <= nums[i + 2] && nums[i + 1] >= nums[i + 3] ||
                nums[i] >= nums[i + 2] && nums[i + 1] <= nums[i + 3]
            ) sum++
        }
        return sum
    }

    fun part2(): Int {
        var sum = 0
        for (i in nums.indices step 4) {
            if (nums[i] > nums[i + 3] || nums[i + 1] < nums[i + 2]
            ) sum++
        }
        return input.size - sum
    }


    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)


    part1().println()
    part2().println()
}
