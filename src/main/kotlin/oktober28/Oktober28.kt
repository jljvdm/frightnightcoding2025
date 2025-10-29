package oktober28

import java.io.BufferedReader
import java.io.InputStreamReader

class Oktober28 {
        val input: List<String>

    constructor() {
        println("Oktober 28")
        input = readFile()
    }

    fun solve(): String {
        val getal = input.first().toLong()
        val maxInt = 4294967296L
        val aantalMaalOverflow = getal / maxInt
        val binaryString = (getal % maxInt).toString(2)
        return "$aantalMaalOverflow,$binaryString"
    }

    private fun readFile(): List<String> {
        val inputStream = javaClass.getResourceAsStream("/oktober28.txt")
            ?: throw IllegalArgumentException("File not found: oktober28.txt")
        return BufferedReader(InputStreamReader(inputStream)).readLines()
    }
}

fun main() {
    val oktober28 = Oktober28()
    println(oktober28.solve())
}