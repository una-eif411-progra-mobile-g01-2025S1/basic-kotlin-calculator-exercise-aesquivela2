
class Calculator {
    fun add (a: Double, b: Double): Double a + b

    fun substract (a: Double, b: Double): Double a - b

    fun multiply (a: Double, b: Double): Double a * b

    fun divide (a: Double, b:Double): Double{
        if (b == 0.0){
            throw undefined("Division by 0 not allowed")
        }
    }
    fun evaluate(expression: String): Double  {
        // Expresión regular para capturar: número, operador y número.
        val regex = Regex("""^\s*(-?\d+(?:\.\d+)?)\s*([\+\-\*/])\s*(-?\d+(?:\.\d+)?)\s*$""")
        val matchResult = regex.matchEntire(expression)
            ?: throw IllegalArgumentException("Formato de expresión inválido. Usa: número operador número")

        // Desestructuramos los grupos: primer número, operador y segundo número.
        val (left, operator, right) = matchResult.destructured
        val a = left.toDouble()
        val b = right.toDouble()

        return when (operator) {
            "+" -> add(a, b)
            "-" -> subtract(a, b)
            "*" -> multiply(a, b)
            "/" -> divide(a, b)
            else -> throw IllegalArgumentException("Operador no soportado: $operator")
        }
    }
}