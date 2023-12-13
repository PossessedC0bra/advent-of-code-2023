package day09

fun parseInput(lines: List<String>) =
    lines.map { line ->
        line.split(" ").map { it.toInt() }
    }


fun extrapolate(numbers: List<Int>): Long {
    var c = 1L
    var s = 0L
    for ((i, x) in numbers.withIndex()) {
        s = c * x - s
        c = c * (numbers.size - i) / (i + 1)
    }
    return s
}

fun part1(input: List<String>): Long {
    val numberSequences = parseInput(input)
    return numberSequences.sumOf { extrapolate(it) }
}

fun part2(input: List<String>): Long {
    val numberSequences = parseInput(input)
    return numberSequences.sumOf { extrapolate(it.reversed()) }
}