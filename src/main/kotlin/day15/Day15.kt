package day15

fun hash(value: String) = value.chars().reduce(0) { acc, v -> ((acc + v) * 17) % 256 }

fun parseInput(input: List<String>) = input.flatMap { it.split(',') }

fun part1(input: List<String>) = parseInput(input)
    .sumOf { hash(it) }

val OPERATION = charArrayOf('-', '=')

fun part2(input: List<String>): Int {
    val steps = parseInput(input)

    val boxes = Array(256) { mutableMapOf<String, Int>() }
    for (step in steps) {
        val operationIdx = step.indexOfAny(OPERATION)
        val label = step.substring(0..<operationIdx)
        when (step[operationIdx]) {
            '-' -> boxes[hash(label)].remove(label)
            '=' -> boxes[hash(label)][label] = step.substring(operationIdx + 1).toInt()
            else -> {}
        }
    }

    return boxes
        .withIndex()
        .sumOf { (boxIdx, box) ->
            (boxIdx + 1) * box.values.withIndex().sumOf { (lensIdx, focalLength) -> (lensIdx + 1) * focalLength }
        }
}