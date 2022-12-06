import java.io.File

fun pt1(input: MutableMap<Int, ArrayDeque<Char>>, insts: List<List<Int>>) {
    for (line in insts) {
        for (n in 0 until line[0]) {
            val f = input[line[1] - 1]?.removeFirstOrNull() ?: break
            input[line[2] - 1]?.addFirst(f)
        }
    }
    println(input)
}

fun pt2(input: MutableMap<Int, ArrayDeque<Char>>, insts: List<List<Int>>) {
    for (line in insts) {
        var l = mutableListOf<Char>()
        for (n in 0 until line[0]) {
            val c = input[line[1] - 1]?.removeFirstOrNull() ?: break
            l.add(c)
        }
        input[line[2] - 1]?.addAll(0, l)
    }
    println(input)
}

fun main(args: Array<String>) {
    val inp: List<String> = File(args[0]).readText().split("\n\n")
    val cranes = inp[0]
        .split("\n")
        .dropLast(1)
        .map { it
            .replace("    ", "[x]")
            .replace(" ", "")
            .drop(1)
            .dropLast(1)
            .replace("][", "")
            .padEnd(9, 'x')
        }
    var craneMap: MutableMap<Int, ArrayDeque<Char>> = mutableMapOf<Int, ArrayDeque<Char>>()
    for (i in 0..8) {
        craneMap[i] = ArrayDeque()
        for (y in cranes.indices) {
            if (cranes[y][i] != 'x') { craneMap[i]?.add(cranes[y][i]) }
        }
    }
    val insts = inp[1]
        .split("\n")
        .map {
            it
                .replace("move ", "")
                .split(" from | to ".toRegex()).map { num ->
                    num.toInt()
                }
        }
//    println("pt1: ${pt1(craneMap, insts)}")
    println("pt2: ${pt2(craneMap, insts)}")
}

main(args)