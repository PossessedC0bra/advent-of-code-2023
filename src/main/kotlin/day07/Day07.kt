val CARD_STRENGTH = "AKQJT98765432"

enum class HandType {
    FIVE_OF_A_KIND,
    FOUR_OF_A_KIND,
    FULL_HOUSE,.
    THREE_OF_A_KIND,
    TWO_PAIR,
    ONE_PAIR,
    HIGH_CARD
}

data class Hand(val cards: CharArray, val type: HandType, val bid: Int) : Comparable<Hand> {

    override operator fun compareTo(other: Hand): Int {
        if (type != other.type) {
            return type compareTo other.type
        }

        var i = 0
        while (i < cards.size - 1 && cards[i] == other.cards[i]) {
            i++
        }

        return CARD_STRENGTH.indexOf(cards[i]) - CARD_STRENGTH.indexOf(other.cards[i])
    }
}

fun parseInput(lines: List<String>): List<Hand> {
    lines.map { line ->
        val parts = line.split(' ', limit = 2)
        val cards = parts[0]
        val bid = parts[1].toInt()

        val cardOccurences = cards.groupingBy { it }.eachCount()
        val handType = when (cardOccurences.entries.size) {
            1 -> HandType.FIVE_OF_A_KIND
            2 -> {
                if (cardOccurences.values.contains(4)) {
                    HandType.FOUR_OF_A_KIND
                }
                HandType.FULL_HOUSE
            }

            3 -> {
                if (cardOccurences.values.contains(3)) {
                    HandType.THREE_OF_A_KIND
                }
                HandType.TWO_PAIR
            }

            4 -> HandType.ONE_PAIR
            else -> HandType.HIGH_CARD
        }

        Hand(cards.toCharArray(), handType, bid)
    }
}

fun part01(input: List<String>) = parseInput(input)
        .sortedBy { it }
        .withIndex()
        .sumOf { it.index * it.value.bid }

