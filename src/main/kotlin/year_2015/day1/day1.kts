package year_2015.day1

import java.io.File

fun pt1(inp:String): Int {
    var ans = 0
    for (chr in inp) {
        when (chr) {
            '(' -> ans += 1
            ')' -> ans -= 1
            else -> print("something weird")
        }
    }
    return ans
}

fun pt2(inp:String): Int {
    var pos = 0
    for ((i, chr) in inp.withIndex()) {
        when (chr) {
            '(' -> pos += 1
            ')' -> {
                pos -= 1
                if (pos == -1) return i + 1
            }
            else -> print("something weird")
        }
    }
    return 999
}

fun main(args: Array<String>) {
    val inp = File(args[0]).readText()
    println("pt1: ${pt1(inp)}")
    println("pt2: ${pt2(inp)}")
}

main(args)