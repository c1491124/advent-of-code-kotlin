fun main() {
    val input = readInput("Day05")

    fun part1(input: List<String>) {
        val lists = MutableList(9) { mutableListOf<Char>() }
        val moves = mutableListOf<String>()
        // init lists and moves by parsing input
        val parsedMoves = parseInputAndInit(input, lists, moves)
        parsedMoves.forEach {
            val (num, from, to) = it
            val toRemove = lists[from].subList(0, num)
            lists[to].reverse()
            lists[to] += toRemove
            lists[to].reverse()
            lists[from] = lists[from].drop(num).toMutableList()
        }
        lists.forEach { print(it[0]) }
    }

    fun part2(input: List<String>) {
        val myLists2 = MutableList(9) { mutableListOf<Char>() }
        val moves = mutableListOf<String>()
        // init lists and moves by parsing input
        val parsedMoves = parseInputAndInit(input, myLists2, moves)
        parsedMoves.forEach {
            val (num, from, to) = it
            val toRemove = myLists2[from].subList(0, num)
            myLists2[to] = (toRemove + myLists2[to]).toMutableList()
            myLists2[from] = myLists2[from].drop(num).toMutableList()
        }
        myLists2.forEach { print(it[0]) }
    }
    part1(input)
    println()
    part2(input)
}
// this function parse input and init the list of crates and move commands,it take the empty lists in,
// then init(mutate) them , the returned moves is something like [[2,7,2],[1,4,8],.....]
fun parseInputAndInit(input: List<String>, lists: List<MutableList<Char>>, moves: MutableList<String>):
        List<List<Int>> {
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
    return moves.map {
        val components = it.split(" ")
        listOf(components[1].toInt(), components[3].toInt() - 1, components[5].toInt() - 1)
    }
}
