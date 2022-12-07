package year_2022.day6

import java.io.File

fun sol(input: String, len: Int):Int? {
    for (i in len - 1 until input.length) {
        if (input.slice(i - (len - 1)..i).toList().distinct().size == len ) {
            return i + 1
        }
    }
    return null
}

fun main(args: Array<String>) {
    val inp: String = File(args[0]).readText()
    println("pt1: ${sol(inp, 4)}")
    println("pt1: ${sol(inp, 14)}")
//    println("pt2: ${inp.map { it.sum() }.sorted().takeLast(3).sum()}")
}

main(args)