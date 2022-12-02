package year_2022.day2

import java.io.File

val games = mapOf(
    listOf("A", "X") to 4,
    listOf("B", "X") to 1,
    listOf("C", "X") to 7,
    listOf("A", "Y") to 8,
    listOf("B", "Y") to 5,
    listOf("C", "Y") to 2,
    listOf("A", "Z") to 3,
    listOf("B", "Z") to 9,
    listOf("C", "Z") to 6,
)

fun pt2(line: List<String>): List<String> {
    val newList: MutableList<String> = mutableListOf(line[0])
    newList.add(
        when (line[1]) {
            "X" -> when (line[0]) {
                "A" -> "Z"
                "B" -> "X"
                "C" -> "Y"
                else -> "this will cause an error later :)"
            }
            "Y" -> when (line[0]) {
                "A" -> "X"
                "B" -> "Y"
                "C" -> "Z"
                else -> "this will cause an error later :)"
            }
            "Z" -> when (line[0]) {
                "A" -> "Y"
                "B" -> "Z"
                "C" -> "X"
                else -> "this will cause an error later :)"
            }
            else -> "this will cause an error later :)"
        }
    )
    return newList
}

fun main(args: Array<String>) {
    val inp: List<List<String>> = File(args[0]).readLines().map {
        it.split(" ")
    }
//    println("$inp")
    println("pt1: ${inp.sumOf { games[it]!! }}")
    println("pt2: ${inp.sumOf { games[pt2(it)]!! }}")
}

main(args)
