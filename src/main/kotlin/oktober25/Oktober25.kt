package oktober25

import java.io.BufferedReader
import java.io.InputStreamReader

class Oktober25 {

    val input: List<String>
    val grid:  Array<Array<Char>> = arrayOf(arrayOf('A','B','C','D'), arrayOf('E','F','G','H'), arrayOf('I','J','K','L'), arrayOf('M','N','O','P'))
    constructor(){
        println("Oktober 25")
        input = readFile()
    }


    fun solve() : String{
        val result : StringBuilder = StringBuilder()
        input.forEach { line ->
            result.append(calculate(line))
        }
        return result.toString()
    }

    private fun readFile(): List<String> {
        val inputStream = javaClass.getResourceAsStream("/oktober25.txt")
            ?: throw IllegalArgumentException("File not found: oktober25.txt")
        return BufferedReader(InputStreamReader(inputStream)).readLines()
    }

    private fun calculate(line: String): Char {
        var x = 0
        var y = 0
        line.split(",").forEach {
            when(it){
                "UP" -> if ( x > 0 ) x -= 1
                "DOWN" -> if ( x < 3 ) x += 1
                "LEFT" -> if ( y > 0 ) y -= 1
                "RIGHT" -> if ( y < 3 ) y += 1
            }
        }
        return grid[x][y]
    }
}

fun main() {
    val oktober25 = Oktober25()
    println(oktober25.solve())
}