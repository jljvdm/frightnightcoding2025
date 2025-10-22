package oktober22

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.jvm.javaClass

class Oktober22 {

    val input: String

    val geteld = mutableMapOf<Int, Int>()

    var result : MutableList<Int> = mutableListOf()

    constructor(){
        println("Oktober 22")
        input = readFile()
    }

    fun solve(): String {
        distinct()
        repeat(4 ){
            var hoogste = 0
            for ( i  in 1..9){
                if ( !result.contains(i) && ( geteld[i] ?: 0 >= geteld[hoogste] ?: 0 )){
                    hoogste = i
                }
            }
            result.add(hoogste)
        }
        return result.joinToString("") { it.toString() }
    }

    private fun readFile(): String {
        val inputStream = javaClass.getResourceAsStream("/oktober22.txt")
            ?: throw IllegalArgumentException("File not found: oktober22.txt")
        return BufferedReader(InputStreamReader(inputStream)).readLines().first()
    }

    private fun distinct() {
        input.toCharArray().forEach {
            geteld[it.digitToInt()] = (geteld[it.digitToInt()] ?: 0) + 1
        }
    }
}

fun main() {
    val oktober22 = Oktober22()
    println(oktober22.solve())
}

