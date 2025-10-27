package oktober27

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

class Oktober27 {

    val input: List<String>

    constructor() {
        println("Oktober 27")
        input = readFile()
    }

    fun solve(): String {
        var sum = 0

        for (i in 1..<input.size) {
            val node1 = input[i - 1].split(",")
            val node2 = input[i].split(",")
            sum += calculateEuclidianDistance(
                node1[0].toDouble(),
                node1[1].toDouble(),
                node1[2].toDouble(),
                node1[3].toDouble(),
                node2[0].toDouble(),
                node2[1].toDouble(),
                node2[2].toDouble(),
                node2[3].toDouble()
            )
        }

        return sum.toString()
    }

    private fun readFile(): List<String> {
        val inputStream = javaClass.getResourceAsStream("/oktober27.txt")
            ?: throw IllegalArgumentException("File not found: oktober27.txt")
        return BufferedReader(InputStreamReader(inputStream)).readLines()
    }

    fun calculateEuclidianDistance(aa: Double, ab: Double, ac: Double, ad: Double, ba: Double, bb: Double, bc: Double, bd: Double): Int {
        return ceil(
            sqrt(
                ((aa - ba).pow(2) + (ab - bb).pow(2) + (ac - bc).pow(2)
                    + (ad - bd).pow(2))
            )
        ).toInt()
    }
}



fun main() {
    val oktober27 = Oktober27()
    println(oktober27.solve())
}
// 154733