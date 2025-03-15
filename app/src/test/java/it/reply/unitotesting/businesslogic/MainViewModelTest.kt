package it.reply.unitotesting.businesslogic

import androidx.compose.ui.graphics.Color

// Necessary imports
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

// Test case class for MainViewModel
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun testExecute_DivideByZero() {
        // Arrange
        viewModel.setFirstOperand("10")
        viewModel.setSecondOperand("0")
        viewModel.setOperator(Operator.DIV)

        // Act
        viewModel.execute()

        // Assert
        assertEquals("Non puoi dividere per 0", viewModel.result.value.result)
        assertEquals(Color.Red, viewModel.result.value.color)
    }

    @Test
    fun testExecute_NonNumericOperands() {
        // Arrange
        viewModel.setFirstOperand("abc")
        viewModel.setSecondOperand("10")
        viewModel.setOperator(Operator.PLUS)

        // Act
        viewModel.execute()

        // Assert
        assertEquals("Controlla il formato degli operandi", viewModel.result.value.result)
        assertEquals(Color.Red, viewModel.result.value.color)
    }

    @Test
    fun testExecute_NoOperatorChosen() {
        // Arrange
        viewModel.setFirstOperand("10")
        viewModel.setSecondOperand("5")

        // Act
        viewModel.execute()

        // Assert
        assertEquals("Imposta un operatore", viewModel.result.value.result)
        assertEquals(Color.Red, viewModel.result.value.color)
    }

    @Test
    fun testExecute_ValidAddition() {
        // Arrange
        viewModel.setFirstOperand("10")
        viewModel.setSecondOperand("5")
        viewModel.setOperator(Operator.PLUS)

        // Act
        viewModel.execute()

        // Assert
        assertEquals("15", viewModel.result.value.result)
        assertEquals(Color.Black, viewModel.result.value.color)
    }

    @Test
    fun testExecute_ValidSubtraction() {
        // Arrange
        viewModel.setFirstOperand("10")
        viewModel.setSecondOperand("5")
        viewModel.setOperator(Operator.MINUS)

        // Act
        viewModel.execute()

        // Assert
        assertEquals("5", viewModel.result.value.result)
        assertEquals(Color.Black, viewModel.result.value.color)
    }

    @Test
    fun testExecute_ValidMultiplication() {
        // Arrange
        viewModel.setFirstOperand("10")
        viewModel.setSecondOperand("5")
        viewModel.setOperator(Operator.MUL)

        // Act
        viewModel.execute()

        // Assert
        assertEquals("50", viewModel.result.value.result)
        assertEquals(Color.Black, viewModel.result.value.color)
    }

    @Test
    fun testExecute_ValidDivision() {
        // Arrange
        viewModel.setFirstOperand("10")
        viewModel.setSecondOperand("2")
        viewModel.setOperator(Operator.DIV)

        // Act
        viewModel.execute()

        // Assert
        assertEquals("5", viewModel.result.value.result)
        assertEquals(Color.Black, viewModel.result.value.color)
    }
}