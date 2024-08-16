import java.io.File
import java.io.IOException

fun main() {
    val fileName = "/home/esther/Downloads/Desafio1/src/itens.txt"
    val carbonFootprintMap = mapOf(
        "Arroz" to 0.2,
        "Feijão" to 0.15,
        "Macarrão" to 0.1,
        "Carne" to 0.5,
        "Leite" to 0.3,
        "Pão" to 0.25,
        "Presunto" to 0.4
    )
    var totalCarbonFootprint = 0.0

    try {
        val fileContent = File(fileName).readLines()
        for (line in fileContent) {
            val (item, quantityStr) = line.split(":").map { it.trim() }
            val quantity = quantityStr.removeSuffix("g").toDoubleOrNull() ?: 0.0

            val carbonPerGram = carbonFootprintMap[item] ?: 0.0

            val carbonFootprint = carbonPerGram.let { it * (quantity / 100) }
            totalCarbonFootprint += carbonFootprint
        }
        println("Total: ${"%.2f".format(totalCarbonFootprint)} kg CO₂")
    } catch (e: IOException) {
        println("Erro ao ler o arquivo: ${e.message}")
    } catch (e: Exception) {
        println("Erro: ${e.message}")
    }
}
