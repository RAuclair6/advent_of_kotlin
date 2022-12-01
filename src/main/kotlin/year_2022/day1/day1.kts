package year_2017.day1

import java.io.File

fun sol(input: String, steps: Int): Int {
    var ans = 0
    for ((i, chr) in input.withIndex()) {
        if (chr == input[(i + steps) % input.length]) {
            ans += chr.digitToInt()
        }
    }
    return ans
}

fun main(args: Array<String>) {
    val inp = File(args[0]).readText()
    println("pt1: ${sol(inp, 1)}")
    println("pt2: ${sol(inp, inp.length / 2)}")
}

main(args)