fun main() {
    fun sonarDataIncreases(next: String, prev: String) = next.toInt() > prev.toInt()

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
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(testInput.size == 2000)
    val resultCount = part1(testInput)
    println("Increases times: " + resultCount)
    check(resultCount == 1559)

    println(part2(testInput))
}
