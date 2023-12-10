package day04

typealias ScratchCard = Pair<Set<Int>, Set<Int>>

val ScratchCard.winningNumbers: Set<Int>
    get() = first

val ScratchCard.availableNumbers: Set<Int>
    get() = second

val NUMBER_REGEX = """(\d+)""".toRegex()

fun parseInput(input: List<String>): List<ScratchCard> = input.map { line ->
    val winningNumbersString = line.substringAfter(':').substringBefore('|')
    val availableNumbersStrings = line.substringAfter("|")

    val winningNumbers = NUMBER_REGEX.findAll(winningNumbersString)
        .flatMap { it.groupValues }
        .map { it.toInt() }
        .toSet()
    val availableNumbers = NUMBER_REGEX.findAll(availableNumbersStrings)
        .flatMap { it.groupValues }
        .map { it.toInt() }
        .toSet()

    winningNumbers to availableNumbers
}

fun part1(input: List<String>): Int {
    val scratchCards = parseInput(input)

    return scratchCards
        .map { (it.winningNumbers intersect it.availableNumbers).size }
        .sumOf { 1 shl it shr 1 }
}

fun part2(input: List<String>): Int {
    val scratchCards = parseInput(input)
    val scratchCardWinnings = scratchCards
        .map { (it.winningNumbers intersect it.availableNumbers).size }

    return IntArray(scratchCards.size) { 1 }.also {
        for ((i, cardWinnings) in scratchCardWinnings.withIndex()) {
            for (j in (i + 1)..(i + cardWinnings).coerceAtMost(it.size)) {
                it[j] += it[i]
            }
        }
    }.sum()
}