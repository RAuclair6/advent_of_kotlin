package year_2022.day1

import java.io.File

fun main(args: Array<String>) {
    val inp: List<List<Int>> = File(args[0]).readText()
        .split("\n\n")
        .map { elf -> elf.split("\n").map { it.toInt() } }
    println("pt1: ${inp.maxOfOrNull { it.sum() }}")
    println("pt2: ${inp.map { it.sum() }.sorted().takeLast(3).sum()}")
}

main(args)