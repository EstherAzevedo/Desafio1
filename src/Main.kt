fun main() {
    val fatorEletricidade = 0.475
    val fatorGasNatural = 2.0

    println("Informe o tipo de energia (1 para Eletricidade, 2 para Gás Natural):")
    val tipoEnergia = readLine()?.toIntOrNull()


    if (tipoEnergia != null) {
        println("Informe o consumo:")
        val consumo = readLine()?.toDoubleOrNull()

        if (consumo != null) {
            val pegadaCarbono = when (tipoEnergia) {
                1 -> consumo * fatorEletricidade
                2 -> consumo * fatorGasNatural
                else -> {
                    println("Tipo de energia inválido.")
                    return
                }
            }
            println("A pegada de carbono total é: $pegadaCarbono kg CO₂")
        } else {
            println("Consumo inválido.")
        }
    } else {
        println("Tipo de energia inválido.")
    }
}
