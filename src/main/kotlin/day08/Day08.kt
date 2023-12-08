package day08

import java.util.function.Predicate
import kotlin.math.max

val NODE_REGEX = """(\w+)\s=\s\((\w+),\s(\w+)\)""".toRegex()

typealias Node = Pair<String, String>

val Node.left: String
    get() = first
val Node.right: String
    get() = second

fun parseInput(input: List<String>): Pair<String, Map<String, Node>> {
    val directions = input[0]
    val nodes = mutableMapOf<String, Pair<String, String>>()

    input
        .drop(2)
        .forEach {
            NODE_REGEX.matchEntire(it)?.let {
                val (key, left, right) = it.destructured
                nodes[key] = left to right
            }
        }

    return directions to nodes
}

fun tracePath(directions: String, startNode: String, nodes: Map<String, Node>, isEndNode: Predicate<String>): Int {
    var dirIdx = 0
    var currentNode = startNode
    var pathLength = 0
    while (!isEndNode.test(currentNode)) {
        currentNode = when (val c = directions[dirIdx]) {
            'L' -> nodes[currentNode]!!.left
            'R' -> nodes[currentNode]!!.right
            else -> throw IllegalStateException("Unknown direction $c")
        }
        dirIdx = (dirIdx + 1) % directions.length
        pathLength++
    }

    return pathLength
}

fun lcm(a: Long, b: Long) = (a * b) / gcd(a, b)

fun gcd(a: Long, b: Long): Long {
    if (b == 0L) {
        return max(a, -a)
    }

    return gcd(b, a % b)
}

fun part1(input: List<String>): Int {
    val (directions, nodes) = parseInput(input)
    return tracePath(directions, "AAA", nodes) { it == "ZZZ" }
}

fun part2(input: List<String>): Long {
    val (directions, nodes) = parseInput(input)

    return nodes.keys
        .filter { it.endsWith('A') }
        .map { startNode -> tracePath(directions, startNode, nodes) { it.endsWith('Z') } }
        .fold(1L) { acc, i -> lcm(acc, i.toLong()) }
}