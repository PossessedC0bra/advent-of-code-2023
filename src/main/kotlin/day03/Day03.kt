package day03

import java.util.function.Predicate

data class Point2d(val x: Int, val y: Int)

data class ParsedNumber(val startPos: Point2d, val value: Int, val length: Int) {
    val neighbouringPositions: Set<Point2d> by lazy {
        setOf(
            *getHorizontalNeighbours(-1),
            Point2d(startPos.x - 1, startPos.y),
            Point2d(startPos.x + length, startPos.y),
            *getHorizontalNeighbours(1)
        )
    }

    private fun getHorizontalNeighbours(yOffset: Int) = (-1..length)
        .map { Point2d(startPos.x + it, startPos.y + yOffset) }
        .toTypedArray()

}

fun parseInput(
    input: List<String>,
    symbolMatcher: Predicate<Char>
): Pair<Array<MutableList<ParsedNumber>>, List<Point2d>> {
    val parsedNumbers = Array<MutableList<ParsedNumber>>(input.size) { mutableListOf() }
    val symbolPositions = mutableListOf<Point2d>()

    input.forEachIndexed { lineIdx, line ->
        var charIdx = 0
        while (charIdx < line.length) {
            when (line[charIdx]) {
                in '0'..'9' -> {
                    val origin = Point2d(charIdx, lineIdx)

                    var number = 0
                    var length = 0
                    while (charIdx < line.length && line[charIdx] in '0'..'9') {
                        number = (number * 10) + (line[charIdx] - '0')
                        charIdx++
                        length++
                    }

                    parsedNumbers[lineIdx].add(ParsedNumber(origin, number, length))
                }

                else -> {
                    if (symbolMatcher.test(line[charIdx])) {
                        symbolPositions.add(Point2d(charIdx, lineIdx))
                    }

                    charIdx++
                }
            }
        }
    }

    return parsedNumbers to symbolPositions
}

fun part1(input: List<String>): Int {
    val (numbers, symbolPositions) = parseInput(input) { it != '.' }

    return numbers
        .flatMap { it }
        .filter { num -> symbolPositions.any { it in num.neighbouringPositions } }
        .sumOf { it.value }
}

fun part2(input: List<String>): Int {
    val (numbers, gearPositions) = parseInput(input) { it == '*' }

    return gearPositions
        .map { gear ->
            (-1..1)
                .flatMap { numbers.getOrNull(gear.y + it) ?: emptyList() }
                .filter { gear in it.neighbouringPositions }
        }
        .filter { it.size == 2 }
        .sumOf { it[0].value * it[1].value }
}