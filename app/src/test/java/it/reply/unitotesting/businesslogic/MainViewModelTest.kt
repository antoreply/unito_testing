package it.reply.unitotesting.businesslogic

import androidx.compose.ui.graphics.Color
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    // Test Requisito 1: Operatore null
    @Test
    fun `execute should return NULL_OPERATOR error when operator is null`() {
        // Arrange
        val operation = OperationModel("5", "3", null)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.NULL_OPERATOR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return NULL_OPERATOR error when operator is null with valid operands`() {
        // Arrange
        val operation = OperationModel("100", "200", null)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.NULL_OPERATOR, result.result)
        assertEquals(Color.Red, result.color)
    }

    // Test Requisito 2: Divisione per zero
    @Test
    fun `execute should return DIV_ZERO_ERROR when dividing by zero`() {
        // Arrange
        val operation = OperationModel("10", "0", Operator.DIV)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.DIV_ZERO_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return DIV_ZERO_ERROR when dividing zero by zero`() {
        // Arrange
        val operation = OperationModel("0", "0", Operator.DIV)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.DIV_ZERO_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return DIV_ZERO_ERROR when dividing negative number by zero`() {
        // Arrange
        val operation = OperationModel("-15", "0", Operator.DIV)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.DIV_ZERO_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    // Test Requisito 3: Formato errato degli operandi - valori non numerici
    @Test
    fun `execute should return WRONG_FORMAT_ERROR when first operand is not numeric`() {
        // Arrange
        val operation = OperationModel("abc", "5", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when second operand is not numeric`() {
        // Arrange
        val operation = OperationModel("10", "xyz", Operator.MINUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when both operands are not numeric`() {
        // Arrange
        val operation = OperationModel("abc", "xyz", Operator.MUL)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when first operand is null`() {
        // Arrange
        val operation = OperationModel(null, "5", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when second operand is null`() {
        // Arrange
        val operation = OperationModel("5", null, Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when both operands are null`() {
        // Arrange
        val operation = OperationModel(null, null, Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when operand is empty string`() {
        // Arrange
        val operation = OperationModel("", "5", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    // Test Requisito 4: Numeri con virgola non accettati
    @Test
    fun `execute should return WRONG_FORMAT_ERROR when first operand is decimal with dot`() {
        // Arrange
        val operation = OperationModel("5.5", "3", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when second operand is decimal with dot`() {
        // Arrange
        val operation = OperationModel("10", "3.14", Operator.MUL)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when first operand is decimal with comma`() {
        // Arrange
        val operation = OperationModel("5,5", "3", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when second operand is decimal with comma`() {
        // Arrange
        val operation = OperationModel("10", "3,14", Operator.MUL)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should return WRONG_FORMAT_ERROR when both operands are decimals`() {
        // Arrange
        val operation = OperationModel("5.5", "3.2", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    // Test Requisito 5: Operazioni valide - Addizione
    @Test
    fun `execute should return correct result for addition of positive numbers`() {
        // Arrange
        val operation = OperationModel("5", "3", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("8", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for addition with zero`() {
        // Arrange
        val operation = OperationModel("10", "0", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("10", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for addition of negative numbers`() {
        // Arrange
        val operation = OperationModel("-5", "-3", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("-8", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for addition of positive and negative`() {
        // Arrange
        val operation = OperationModel("10", "-3", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("7", result.result)
        assertEquals(Color.Black, result.color)
    }

    // Test Requisito 5: Operazioni valide - Sottrazione
    @Test
    fun `execute should return correct result for subtraction of positive numbers`() {
        // Arrange
        val operation = OperationModel("10", "3", Operator.MINUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("7", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for subtraction resulting in negative`() {
        // Arrange
        val operation = OperationModel("3", "10", Operator.MINUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("-7", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for subtraction with zero`() {
        // Arrange
        val operation = OperationModel("10", "0", Operator.MINUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("10", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for subtraction of negative numbers`() {
        // Arrange
        val operation = OperationModel("-5", "-3", Operator.MINUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("-2", result.result)
        assertEquals(Color.Black, result.color)
    }

    // Test Requisito 5: Operazioni valide - Moltiplicazione
    @Test
    fun `execute should return correct result for multiplication of positive numbers`() {
        // Arrange
        val operation = OperationModel("5", "3", Operator.MUL)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("15", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for multiplication by zero`() {
        // Arrange
        val operation = OperationModel("10", "0", Operator.MUL)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("0", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for multiplication by one`() {
        // Arrange
        val operation = OperationModel("10", "1", Operator.MUL)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("10", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for multiplication of negative numbers`() {
        // Arrange
        val operation = OperationModel("-5", "-3", Operator.MUL)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("15", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for multiplication of positive and negative`() {
        // Arrange
        val operation = OperationModel("5", "-3", Operator.MUL)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("-15", result.result)
        assertEquals(Color.Black, result.color)
    }

    // Test Requisito 5: Operazioni valide - Divisione
    @Test
    fun `execute should return correct result for division of positive numbers`() {
        // Arrange
        val operation = OperationModel("15", "3", Operator.DIV)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("5", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for division with remainder (integer division)`() {
        // Arrange
        val operation = OperationModel("10", "3", Operator.DIV)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("3", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for division by one`() {
        // Arrange
        val operation = OperationModel("10", "1", Operator.DIV)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("10", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for division of negative numbers`() {
        // Arrange
        val operation = OperationModel("-15", "-3", Operator.DIV)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("5", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for division of positive by negative`() {
        // Arrange
        val operation = OperationModel("15", "-3", Operator.DIV)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("-5", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should return correct result for zero divided by positive number`() {
        // Arrange
        val operation = OperationModel("0", "5", Operator.DIV)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("0", result.result)
        assertEquals(Color.Black, result.color)
    }

    // Test casi limite aggiuntivi
    @Test
    fun `execute should handle large numbers correctly`() {
        // Arrange
        val operation = OperationModel("1000000", "2000000", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("3000000", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should handle leading zeros in operands`() {
        // Arrange
        val operation = OperationModel("005", "003", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals("8", result.result)
        assertEquals(Color.Black, result.color)
    }

    @Test
    fun `execute should handle spaces in operands as wrong format`() {
        // Arrange
        val operation = OperationModel("5 5", "3", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }

    @Test
    fun `execute should handle special characters as wrong format`() {
        // Arrange
        val operation = OperationModel("5@", "3", Operator.PLUS)

        // Act
        val result = viewModel.execute(operation)

        // Assert
        assertEquals(MainViewModel.WRONG_FORMAT_ERROR, result.result)
        assertEquals(Color.Red, result.color)
    }
}