package year_2015.day2

import java.io.File

fun pt1(inp:List<String>):Int {
    var ans:Int = 0
    for (line in inp) {
        var vals:List<Int> = line.split('x').map { it.toInt() }
        var areas:List<Int> = listOf(
            2 * vals[0] * vals[1],
            2 * vals[0] * vals[2],
            2 * vals[2] * vals[1]
        )
        ans += areas.min() / 2 + areas.sum()
    }
    return ans
}

fun pt2(inp:List<String>):Int {
    var ans:Int = 0
    for (line in inp) {
        var vals:List<Int> = line.split('x').map { it.toInt() }
        vals = vals.sorted()
        ans += (2 * vals[0] + 2 * vals[1]) + (vals.reduce { acc, i -> acc * i } )
    }
    return ans
}
fun main(args: Array<String>) {
    var inp = File(args[0]).readLines()
    println("pt1: ${pt1(inp)}")
    println("pt2: ${pt2(inp)}")
}

main(args)