package it.reply.unitotesting.businesslogic

data class OperationModel(
    val firstOperand: String? = null,
    val secondOperand: String? = null,
    val operator: Operator? = null
)


enum class Operator(val value:String){
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/")
}