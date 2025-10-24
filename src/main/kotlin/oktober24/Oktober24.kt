package oktober24

import java.io.BufferedReader
import java.io.InputStreamReader

class Oktober24 {
    val input: String

    constructor(){
        println("Oktober 24")
        input = readFile()
    }

    fun solve() : String{
        return "TBD"
    }

    private fun readFile(): String {
        val inputStream = javaClass.getResourceAsStream("/oktober24.txt")
            ?: throw IllegalArgumentException("File not found: oktober24.txt")
        return BufferedReader(InputStreamReader(inputStream)).readLines().first()
    }

}


fun main() {
    val oktober24 = Oktober24()
    println(oktober24.solve())
}