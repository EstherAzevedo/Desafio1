fun main() {
    val emissoes = arrayOf(0.21, 0.105, 0.133)

    println("Digite a distância percorrida em km:")
    val distancia = readLine()?.toDoubleOrNull() ?: 0.0

    println("Escolha o meio de transporte (1 - Carro, 2 - Ônibus, 3 - Avião):")
    val transporte = readLine()?.toIntOrNull() ?: 1

    val pegadaCarbono = calcularPegadaCarbono(transporte, distancia, emissoes)

    println("A pegada de CO₂ para esta viagem é: ${"%.2f".format(pegadaCarbono)} kg")
}

fun calcularPegadaCarbono(transporte: Int, distancia: Double, emissoes: Array<Double>): Double {
    return when (transporte) {
        1 -> distancia * emissoes[0]  // Carro
        2 -> distancia * emissoes[1]  // Ônibus
        3 -> distancia * emissoes[2]  // Avião
        else -> 0.0
    }
}

