import java.io.File
import java.util.Deque

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
    var craneMap: MutableMap<Int, ArrayDeque<Char>> = mutableMapOf()
    for (i in 0..8) {
        craneMap[i] = ArrayDeque()
        for (y in cranes.indices) {
            if (cranes[y][i] != 'x') { craneMap[i]?.add(cranes[y][i]) }
        }
    }
    val insts = inp[1]
}

main(args)