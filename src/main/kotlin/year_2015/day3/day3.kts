package year_2015.day3

import java.io.File

class Santa(
    var x: Int = 0,
    var y: Int = 0,
    var visited: HashSet<Pair<Int,Int>> = hashSetOf(Pair(0,0)),
) {
    fun num():Int {return this.visited.size}
    fun updatePos(dir:Char) {
        when (dir) {
            '>' -> this.x += 1
            '<' -> this.x -= 1
            '^' -> this.y += 1
            'v' -> this.y -= 1
            else -> println("invalid dir for updatePos")
        }
        this.visited.add(Pair(x,y))
    }
    fun merge(otherSanta:Santa) {
        this@Santa.visited.addAll(otherSanta.visited)
    }
}

fun pt1(inp:String):Int  {
    val santa = Santa()
    for (chr in inp) {
        santa.updatePos(chr)
    }
    return santa.num()
}

fun pt2(inp:String):Int  {
    val santa = Santa()
    val robotSanta = Santa()
    for ((i, chr) in inp.withIndex()) {
        if (i % 2 == 0) { santa.updatePos(chr) }
        else { robotSanta.updatePos(chr) }
    }
    santa.merge(robotSanta)
    return santa.num()
}

fun main(args: Array<String>) {
    val inp = File(args[0]).readText()
    println("pt1: ${pt1(inp)}")
    println("pt2: ${pt2(inp)}")
}

main(args)
