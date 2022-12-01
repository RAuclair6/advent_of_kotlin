package year_2017.day2

import java.io.File

fun find_divis(line: List<Int>): Int? {
    val ls = line.sortedDescending()
    for ((idx, n) in ls.withIndex()) {
        for (m in ls.slice(idx + 1 until line.size)) {
            if (n % m == 0) {
                return n / m
            }
        }
    }
    return null
}

fun pt1(input: List<List<Int>>): Int {
    return input.sumOf { it.max() - it.min() }
}

fun pt2(input: List<List<Int>>): Int {
    return input.sumOf { find_divis(it)!! }
}

fun main(args: Array<String>) {
    val inp = File(args[0]).readLines().map { line -> line.split("\\s".toRegex()).map { it.toInt() } }
    println("pt1: ${pt1(inp)}")
    println("pt2: ${pt2(inp)}")
}

main(args)
