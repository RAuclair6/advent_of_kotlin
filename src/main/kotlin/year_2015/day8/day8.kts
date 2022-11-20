package year_2015.day8

import java.io.File

fun countString1(inp: String): Int {
    var s = inp.drop(1)
    s = s.dropLast(1)
    s = s.replace("\\\\x..|\\\\\"|\\\\{2}".toRegex(), "a")
    return s.length
}

fun countString2(inp: String): Int {
    var s = inp
    s = s.replace("\\\\\"|\\\\{2}".toRegex(), "aaaa")
    s = s.replace("\\\\x..".toRegex(), "aaaaa")
    return s.length + 4
}

fun pt1(inp: List<String>, part: Int): Int {
    var codeNum = 0
    var stringNum = 0
    if (part == 1) {
        for (line in inp) {
            codeNum += line.length
            stringNum += countString1(line)
        }
    }
    if (part == 2) {
        for (line in inp) {
            codeNum += line.length
            stringNum += countString2(line)
        }
    }
    return codeNum - stringNum
}

fun main(args: Array<String>) {
    val inp = File(args[0]).readLines()
    println("pt1: ${pt1(inp, 1)}")
    println("pt2: ${-pt1(inp, 2)}")
}

main(args)