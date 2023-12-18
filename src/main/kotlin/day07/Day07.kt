package day07

val CARD_STRENGTH = "AKQJT98765432"

enum class HandType {
    FIVE_OF_A_KIND,
    FOUR_OF_A_KIND,
    FULL_HOUSE,
    THREE_OF_A_KIND,
    TWO_PAIR,
    ONE_PAIR,
    HIGH_CARD
}

data class Hand(val cards: CharArray, val type: HandType, val bid: Int) : Comparable<Hand> {

    override operator fun compareTo(other: Hand): Int {
        if (type != other.type) {
            return type compareTo other.type;
        }

        var i = 0
        while (i < cards.size - 1 && cards[i] == other.cards[i]) {
            i++
        }

        return CARD_STRENGTH.indexOf(cards[i]) compareTo CARD_STRENGTH.indexOf(other.cards[i])
    }
}

fun parseInput(lines: List<String>) = lines.map { line ->
    val parts = line.split(" ")
    val cards = parts[0]
    val bid = parts[1].toInt()

    val cardOccurences = cards.groupingBy { it }.eachCount()
    val handType = when (cardOccurences.entries.size) {
        1 -> HandType.FIVE_OF_A_KIND
        2 -> when (cardOccurences.values.contains(4)) {
            true -> HandType.FOUR_OF_A_KIND
            else -> HandType.FULL_HOUSE
        }

        3 -> when (cardOccurences.values.contains(3)) {
            true -> HandType.THREE_OF_A_KIND
            else -> HandType.TWO_PAIR
        }

        4 -> HandType.ONE_PAIR
        else -> HandType.HIGH_CARD
    }

    Hand(cards.toCharArray(), handType, bid)
}

fun part1(input: List<String>) = parseInput(input)
    .sortedDescending()
    .withIndex()
    .sumOf { (it.index + 1) * it.value.bid }

