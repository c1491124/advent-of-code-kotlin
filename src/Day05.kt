fun main() {
    val input = readInput("Day05")
    val lists = List(9) { mutableListOf<Char>() }
    val moves = mutableListOf<String>()
    // init lists and moves
    input.forEachIndexed { index, s ->
        if (index <= 9) {
            s.forEachIndexed { i, c ->
                if (c == '[') {
                    lists[i / 4].add(s[i + 1])
                }
            }
        } else {
            moves += s
        }
    }
    val parsedMoves = moves.map {
        val components = it.split(" ")
        listOf(components[1].toInt(), components[3].toInt() - 1, components[5].toInt() - 1)
    }

    // resolve command
    fun part1(lists: List<MutableList<Char>>) {
        val myLists = lists.map { it }.toMutableList()  // use map() as deep copy
        parsedMoves.forEach {
            val (num, from, to) = it
            val toRemove = myLists[from].subList(0, num)
            myLists[to].reverse()
            myLists[to] += toRemove
            myLists[to].reverse()
            myLists[from] = myLists[from].drop(num).toMutableList()
        }
        myLists.forEach { print(it[0]) }
    }

    fun part2(lists: List<MutableList<Char>>) {
        val myLists2 = lists.map { it }.toMutableList()   // use copyOf() as deep copy
        parsedMoves.forEach {
            val (num, from, to) = it
            val toRemove = myLists2[from].subList(0, num)
            myLists2[to] = (toRemove + myLists2[to]).toMutableList()
            myLists2[from] = myLists2[from].drop(num).toMutableList()
        }
        myLists2.forEach { print(it[0]) }
    }
    part1(lists)
    println()
    part2(lists)
}
