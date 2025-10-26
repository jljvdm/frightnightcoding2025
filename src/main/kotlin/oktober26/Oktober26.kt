package oktober26

import java.io.BufferedReader
import java.io.InputStreamReader

class Oktober26 {

    val input: String

    var result : String

    val matchingAllNotes = Regex("(?=.*A)(?=.*B)(?=.*C)(?=.*D)(?=.*E)(?=.*F)(?=.*G)")

    constructor() {
        println("Oktober 26")
        input = readFile()
        result = input
    }

    private fun readFile(): String {
        val inputStream = javaClass.getResourceAsStream("/oktober26.txt")
            ?: throw IllegalArgumentException("File not found: oktober26.txt")
        return BufferedReader(InputStreamReader(inputStream)).readLines().first()
    }

    fun solve(): String {
        for( start in 0..input.length - 7){
            for ( end in start + 7 .. input.length ){
                if ( end - start <= result.length ){
                    val substring = input.substring(start, end)
                    if ( matchingAllNotes.containsMatchIn(substring) && substring.length < result.length){
                            result = substring
                    }
                }

            }
        }
        return result
    }



}

fun main() {
    val oktober26 = Oktober26()
    println(oktober26.solve())
}