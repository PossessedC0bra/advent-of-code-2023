package day01

fun part1(lines: List<String>): Int {
    var sum = 0

    for (line in lines) {
        var leftMostNumberIndex = -1
        var rightMostNumberIndex = -1

        var i = 0
        while ((leftMostNumberIndex == -1 || rightMostNumberIndex == -1) && i < line.length) {
            val leftIndex = i
            val rightIndex = line.length - i - 1

            if (leftMostNumberIndex == -1 && line[leftIndex] in '0'..'9') {
                leftMostNumberIndex = leftIndex
            }
            if (rightMostNumberIndex == -1 && line[rightIndex] in '0'..'9') {
                rightMostNumberIndex = rightIndex
            }

            i++
        }

        sum += (line[leftMostNumberIndex] - '0') * 10
        sum += line[rightMostNumberIndex] - '0'
    }

    return sum
}

fun part2(lines: List<String>): Int {
    var sum = 0

    for (line in lines) {
        val parsedNumbers = mutableListOf<Int>()

        var idx = 0
        while (idx < line.length) {
            val (offset, number) = parseNumber(line, idx)
            number?.let {
                parsedNumbers.add(it)
            }
            idx += offset
        }

        sum += parsedNumbers.first() * 10 + parsedNumbers.last()
    }

    return sum
}

fun parseNumber(s: String, startCharIdx: Int): Pair<Int, Int?> {
    if (s[startCharIdx] in '0'..'9') {
        return 1 to s[startCharIdx] - '0'
    }

    for ((digitIdx, digit) in arrayOf(
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    ).withIndex()) {
        var digitCharIdx = 0
        while (digitCharIdx < digit.length && startCharIdx + digitCharIdx < s.length && digit[digitCharIdx] == s[startCharIdx + digitCharIdx]) {
            digitCharIdx++
        }

        if (digitCharIdx == digit.length) {
            return digit.length to digitIdx + 1
        }
    }

    return 1 to null
}