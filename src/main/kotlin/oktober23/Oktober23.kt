package oktober23

import java.io.BufferedReader
import java.io.InputStreamReader

class Oktober23 {

    val input: String

    constructor(){
        println("Oktober 23")
        input = readFile()
    }


    fun solve(): String{
        var opgeteldeWaardes = input.split(",").map { input -> input.toInt() }.sum()
        return (((opgeteldeWaardes % 360) + 360) % 360).toString()
    }

    private fun readFile(): String {
        val inputStream = javaClass.getResourceAsStream("/oktober23.txt")
            ?: throw IllegalArgumentException("File not found: oktober23.txt")
        return BufferedReader(InputStreamReader(inputStream)).readLines().first()
    }
}

fun main() {
    val oktober23 = Oktober23()
    println(oktober23.solve())
}