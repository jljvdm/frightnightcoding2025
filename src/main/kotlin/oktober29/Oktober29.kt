package oktober29

import java.io.BufferedReader
import java.io.InputStreamReader

class Oktober29 {
    val input: String
    var gesorteerdeLijst = emptyList<String>()

    constructor() {
        println("Oktober 29")
        input = readFile()
    }

    fun solve(): String {
        gesorteerdeLijst = geefLijstMetGesorteerdeStrings()
        var zoeksleutel = ""
        for (i in 1 until gesorteerdeLijst.size - 1) {
            if (gesorteerdeLijst[i] != gesorteerdeLijst[i + 1] && gesorteerdeLijst[i] != gesorteerdeLijst[i - 1]) {
                zoeksleutel = gesorteerdeLijst[i]
                break
            }
        }
        return zoekInDeLijst(zoeksleutel)
    }

    private fun zoekInDeLijst(zoekString: String): String {
        for (string in input.split(" ")) {
            string.toCharArray().sorted().joinToString("")
                .let {
                    if (it == zoekString) return string
                }
        }
        return "-"
    }


    private fun geefLijstMetGesorteerdeStrings(): List<String> {
        return input.split(" ").map { it.toCharArray().sorted().joinToString("") }.sorted()
    }

    private fun readFile(): String {
        val inputStream = javaClass.getResourceAsStream("/oktober29.txt")
            ?: throw IllegalArgumentException("File not found: oktober29.txt")
        return BufferedReader(InputStreamReader(inputStream)).readLines().first()
    }
}


fun main() {
    val oktober29 = Oktober29()
    println(oktober29.solve())
}