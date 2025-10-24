package oktober24

import java.io.BufferedReader
import java.io.InputStreamReader

class Oktober24 {
    val input: String
    var geteld = emptyMap<Char, Int>()

    constructor(){
        println("Oktober 24")
        input = readFile()
    }

    fun solve() : String{
        telKarakters()
        return geteld.keys.filter {  sleutel -> geteld[sleutel] == 1 }.joinToString("")
    }

    private fun readFile(): String {
        val inputStream = javaClass.getResourceAsStream("/oktober24.txt")
            ?: throw IllegalArgumentException("File not found: oktober24.txt")
        return BufferedReader(InputStreamReader(inputStream)).readLines().first()
    }

    private fun telKarakters() {
        geteld = input.groupingBy { it }.eachCount()
    }

}


fun main() {
    val oktober24 = Oktober24()
    println(oktober24.solve())
}