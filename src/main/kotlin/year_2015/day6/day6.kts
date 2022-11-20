package year_2015.day6

import java.io.File

data class ParsedLine(
    var inst: String,
    var xCoord: IntRange,
    var yCoord: IntRange,
)

fun instCheck(data: List<String>): Pair<String, List<String>> {
    return if (data[0] == "toggle") {
        Pair(
            "toggle",
            data.drop(1).toString()
                .replace("[", "")
                .replace("]", "")
                .split(", through, ")
        )
    } else {
        Pair(
            data[1],
            data.drop(2).toString()
                .replace("[", "")
                .replace("]", "")
                .split(", through, ")
        )
    }
}

fun parseLine(data: String): ParsedLine {
//    return instruction (toggle, on, off) along with range of x and y values
    val (inst, ranges) = instCheck(data.split(' '))
    val x = ranges[0].split(',')[0].toInt()..ranges[1].split(',')[0].toInt()
    val y = ranges[0].split(',')[1].toInt()..ranges[1].split(',')[1].toInt()
    return ParsedLine(inst = inst, xCoord = x, yCoord = y)
}

fun pt1(inp: List<String>): Int {
    var ans = 0
    val arr = Array(1000) { Array(1000) { 0 } }
    for (line in inp) {
        val p = parseLine(line)
        for (y in p.yCoord) {
            for (x in p.xCoord) {
                when (p.inst) {
                    "toggle" -> {
                        if (arr[y][x] == 0) {
                            arr[y][x] = 1
                        } else {
                            arr[y][x] = 0
                        }
                    }
                    "on" -> arr[y][x] = 1
                    "off" -> arr[y][x] = 0
                    else -> println("unexpected instruction")
                }
            }
        }
    }
    for (element in arr) {
        ans += element.sum()
    }
    return ans
}

fun pt2(inp: List<String>): Int {
    var ans = 0
    val arr = Array(1000) { Array(1000) { 0 } }
    for (line in inp) {
        val p = parseLine(line)
        for (y in p.yCoord) {
            for (x in p.xCoord) {
                when (p.inst) {
                    "toggle" -> arr[y][x] += 2
                    "on" -> arr[y][x] += 1
                    "off" -> {
                        if (arr[y][x] > 0) {
                            arr[y][x] -= 1
                        }
                    }
                    else -> println("unexpected instruction")
                }
            }
        }
    }
    for (element in arr) {
        ans += element.sum()
    }
    return ans
}

fun main(args: Array<String>) {
    val inp = File(args[0]).readLines()
    println("pt1: ${pt1(inp)}")
    println("pt2: ${pt2(inp)}")
}

main(args)