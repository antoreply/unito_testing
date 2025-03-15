package it.reply.unitotesting.businesslogic

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _isAmountMenuExpanded = mutableStateOf(false)
    val isAmountMenuExpanded: MutableState<Boolean> = _isAmountMenuExpanded

    private val _result = mutableStateOf(ResultModel())
    val result: MutableState<ResultModel> = _result

    // Funzione da svuotare e testare
    fun execute(operation: OperationModel){

    }

    /** Pass to this function the result you want to print **/
    private fun updateResult(resultModel: ResultModel){
        _result.value = resultModel
    }

    companion object{
        const val DIV_ZERO_ERROR = "Non puoi dividere per 0"
        const val WRONG_FORMAT_ERROR = "Controlla il formato degli operandi"
        const val NULL_OPERATOR = "Imposta un operatore"
    }

}