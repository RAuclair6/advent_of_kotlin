package year_2022.day4

import org.w3c.dom.ranges.Range
import java.io.File

fun pt1(input: List<List<Pair<Int, Int>>>): Int {
    var ans = 0
    for (line in input) {
        if ((line[0].first - line[1].first <= 0) && (line[0].second - line[1].second >= 0) ||
            (line[1].first - line[0].first <= 0) && (line[1].second - line[0].second >= 0)
        ) {
            ans += 1
        }
    }
    return ans
}

fun pt2(input: List<List<Pair<Int, Int>>>): Int {
    var ans = 0
    for (line in input) {
        if (line[0].first <= line[1].second && line[0].second >= line[1].first) {
            ans += 1
        }
    }
    return ans
}

fun main(args: Array<String>) {
    val inp: List<List<Pair<Int, Int>>> = File(args[0])
        .readLines()
        .map {
            it.split(",").map { inner ->
                val spl = inner.split("-")
                Pair(spl[0].toInt(), spl[1].toInt())
            }
        }
//    println("$inp")
    println("pt1: ${pt1(inp)}")
    println("pt2: ${pt2(inp)}")
}

main(args)
