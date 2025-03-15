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

    fun getOperands(): Array<String?>{
        return arrayOf(firstOperand,secondOperand)
    }

    fun isFirstOperandEven(): Boolean {
        return if (firstOperand?.toIntOrNull() == null) false
        else firstOperand!!.toInt() % 2 == 0
    }

    override fun equals(other: Any?): Boolean {
        return if (other is OperationModel){
            when{
                other.firstOperand != this.firstOperand -> false
                other.secondOperand != this.secondOperand -> false
                other.operator != this.operator -> false
                else -> true
            }
        } else false
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

}


enum class Operator(val value:String){
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/")
}