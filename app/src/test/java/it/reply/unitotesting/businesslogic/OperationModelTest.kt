package it.reply.unitotesting.businesslogic

import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test

class OperationModelTest {

    @Test
    fun `getFirstOperand should return the first operand`(){
        val firstOperand = "1"
        val secondOperand = "1"
        val operator = Operator.PLUS

        val operation = OperationModel(firstOperand,secondOperand,operator)

        assertEquals(operation.getFirstOperand(),firstOperand)
    }

    @Test
    fun `getSecondOperand should return the second operand`(){
        // TODO
    }

    @Test
    fun `getOperator should return the operator`(){
        // TODO
    }

    // TODO This test fails. Understand why and fix it by changing the assert function.
    @Test
    fun `getOperands should return the array of operands`(){
        val firstOperand = "2"
        val secondOperand = "1"
        val operator = Operator.PLUS

        val operation = OperationModel(firstOperand,secondOperand,operator)

        assertEquals(operation.getOperands(), listOf(firstOperand,secondOperand))
    }

    @Test
    fun `check if first operand is even`(){
        val firstOperand = "2"
        val secondOperand = "1"
        val operator = Operator.PLUS

        val operation = OperationModel(firstOperand,secondOperand,operator)

        assertTrue(operation.isFirstOperandEven())
    }

    // TODO This test fails. Understand why and fix it by changing the assert function.
    @Test
    fun `check if first operand is even (decimal)`(){
        val firstOperand = "2.1"
        val secondOperand = "1"
        val operator = Operator.PLUS

        val operation = OperationModel(firstOperand,secondOperand,operator)

        assertTrue(operation.isFirstOperandEven())
    }

    // TODO This test fails. Undertand why and fix it by changing the assert function.
    @Test
    fun `operations equality`(){
        val firstOperation = OperationModel("1","1",Operator.PLUS)
        val secondOperation = OperationModel("1","1",Operator.PLUS)

        assertSame(firstOperation,secondOperation)
    }

}