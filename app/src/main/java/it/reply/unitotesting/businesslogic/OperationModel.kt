package it.reply.unitotesting.businesslogic

interface Operation{
    fun getFirstOperand(): String?
    fun getSecondOperand(): String?
    fun getOperator(): Operator?
}

class OperationModel(): Operation{

    private var firstOperand: String? = null

    private var secondOperand: String? = null

    private var operator: Operator? = null

    constructor(firstOperand: String?, secondOperand: String?, operator: Operator?) : this() {
        this.firstOperand = firstOperand
        this.secondOperand = secondOperand
        this.operator = operator
    }

    override fun getFirstOperand(): String? {
        return firstOperand
    }

    override fun getSecondOperand(): String? {
        return secondOperand
    }

    override fun getOperator(): Operator? {
        return operator
    }

    fun getOperands(): List<String?>{
        return listOf(firstOperand,secondOperand)
    }

}


enum class Operator(val value:String){
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/")
}