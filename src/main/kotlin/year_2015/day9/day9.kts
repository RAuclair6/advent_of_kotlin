package year_2015.day9

import java.io.File
//import org.apache.commons.math3.util.Combinations
// I think I actually want permutations, not combinations

fun parseLine(line: String): Pair<Set<String>, Int> {
    val spl1 = line.split(" = ", limit = 2)
    val cities = spl1[0].split(" to ").toSet()
    val distance = spl1[1].toInt()
    return Pair(cities, distance)
}

fun pt1(inp: List<String>) {
    val weights = HashMap<Set<String>, Int>()

    for (line in inp) {
        val parsed = parseLine(line)
        weights[parsed.first] = parsed.second
    }
    // .keys gives a set of sets, flatten gives an array of their elements, convert back to a set to get distinct cities
    val allCities = weights.keys.flatten().toSet()
//    val paths = Combinations

}


fun main(args: Array<String>) {
    val inp = File(args[0]).readLines()
    println("pt1: ${pt1(inp)}")
}

main(args)