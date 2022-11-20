package year_2015.day7

import java.io.File

// I'm sure this could be a lot more DRY

fun parseSig(inst: List<String>, table: HashMap<String, Int>): Int? {
    when {
        inst[0] == "NOT" -> {
            if (inst[1] in table.keys) {
                return table[inst[1]]?.inv()
            }
        }
        inst[1] == "AND" -> {
            when (inst[0].toIntOrNull()) {
                is Int -> {
                    if (inst[2] in table.keys) {
                        return inst[0].toInt().and(table[inst[2]]!!)
                    }
                }
                else -> if (inst[0] in table.keys && inst[2] in table.keys) {
                    return table[inst[0]]!!.and(table[inst[2]]!!)
                }
            }

        }
        inst[1] == "OR" -> {
            if (inst[0] in table.keys && inst[2] in table.keys) {
                return table[inst[0]]!!.or(table[inst[2]]!!)
            }
        }
        inst[1] == "LSHIFT" -> {
            if (inst[0] in table.keys) {
                return table[inst[0]]!!.shl(inst[2].toInt())
            }
        }
        inst[1] == "RSHIFT" -> {
            if (inst[0] in table.keys) {
                return table[inst[0]]!!.shr(inst[2].toInt())
            }
        }
    }
    return null
}

fun pt1(inp: List<String>): Int {
    val table = HashMap<String, Int>()
    val used = mutableListOf<Int>()
    while ("a" !in table.keys) {
        for ((i, line) in inp.withIndex()) {
            if (i !in used) {
                val spl = line.split(" -> ")
                val inst = spl[0].split(" ")
                if (inst.size == 1) { // for a case such as 14146 -> b
                    when (inst[0].toIntOrNull()) {
                        is Int -> {
                            table[spl[1]] = inst[0].toInt()
                            used.add(i)
                        }
                        else -> {
                            if (inst[0] in table.keys) {
                                table[spl[1]] = table[inst[0]]!!
                                used.add(i)
                            }
                        }
                    }

                } else {
                    val signal = parseSig(inst, table)
                    if (signal != null) {
                        table[spl[1]] = signal
                        used.add(i)
                    }
                }
            }
        }
    }
    return table["a"]!!
}

fun main(args: Array<String>) {
    val inp = File(args[0]).readLines()
    println("pt1: ${pt1(inp)}") // for part 2 just change argument file to input7pt2.txt – just modified b there
}

main(args)