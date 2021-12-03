fun main() {
    fun sonarDataIncreases(next: String, prev: String) = next.toLong() > prev.toLong()

    fun part1(input: List<String>): Int {
        var count = 0

        val iterator = input.iterator()
        var prev: String? = null
        while (iterator.hasNext()) {
            val next = iterator.next()

            if (prev != null && sonarDataIncreases(next, prev)) {
                count++
            }

            prev = next
        }

        return count
    }

    fun part2(input: List<String>): Int {
        val iterator = input.iterator()
        val slidingWindowEntries = mutableListOf<String>()

        for ((index, value) in iterator.withIndex()) {
            val indexSecond = index + 1
            val seconWindowEntry = input.getOrNull(indexSecond)

            val indexThird = index + 2
            val thirdWindowEntry = input.getOrNull(indexThird)

            if (seconWindowEntry != null && thirdWindowEntry != null) {
                val sumOfSlidingWindow = value.toLong() + seconWindowEntry.toLong() + thirdWindowEntry.toLong()
                slidingWindowEntries.add(sumOfSlidingWindow.toString())
            }
        }

        return part1(slidingWindowEntries)
    }

    val testInput = readInput("Day01_test")
    check(testInput.size == 2000)
    val resultCountPart1 = part1(testInput)
    println("Part 1 increases times: " + resultCountPart1)
    check(resultCountPart1 == 1559)

    check(testInput.size == 2000)
    val resultCountPart2 = part2(testInput)
    println("Part2 increases times: " + resultCountPart2)
    check(resultCountPart2 == 1600)
}
