package your.package.name

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    // Pruebas para operaciones básicas usando evaluate

    @Test
    fun testEvaluateAddition() {
        val result = calculator.evaluate("5 + 3")
        assertEquals(8.0, result)
    }

    @Test
    fun testEvaluateSubtraction() {
        val result = calculator.evaluate("10 - 4")
        assertEquals(6.0, result)
    }

    @Test
    fun testEvaluateMultiplication() {
        val result = calculator.evaluate("2 * 3")
        assertEquals(6.0, result)
    }

    @Test
    fun testEvaluateDivision() {
        val result = calculator.evaluate("10 / 2")
        assertEquals(5.0, result)
    }

    @Test
    fun testEvaluateDivisionByZero() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("10 / 0")
        }
        assertEquals("Division by zero is not allowed", exception.message)
    }

    // Prueba para formato inválido
    @Test
    fun testEvaluateInvalidFormat() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            calculator.evaluate("5++3")
        }
        assertTrue(exception.message!!.contains("Formato de expresión inválido"))
    }

    // Pruebas adicionales para casos con espacios y números negativos
    @Test
    fun testEvaluateWithSpacesAndNegatives() {
        assertEquals(-2.0, calculator.evaluate(" -5   +  3"))
        assertEquals(-8.0, calculator.evaluate(" -5 - 3"))
        assertEquals(15.0, calculator.evaluate(" -5 * -3"))
    }
}
