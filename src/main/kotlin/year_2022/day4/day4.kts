package year_2022.day4

import java.io.File

fun main(args: Array<String>) {
    val inp: List<List<IntRange>> = File(args[0])
        .readLines()
        .map {
            it.split(",").map { inner ->
                val spl = inner.split("-")
                spl[0].toInt()..spl[1].toInt()
            }
        }
    println(
        "pt1: ${
            inp.count {
                (it[0].first - it[1].first <= 0) && (it[0].last - it[1].last >= 0) || 
                (it[1].first - it[0].first <= 0) && (it[1].last - it[0].last >= 0)
            }
        }"
    )
    println("pt2: ${inp.count { it[0].first <= it[1].last && it[0].last >= it[1].first }}")
}

main(args)
