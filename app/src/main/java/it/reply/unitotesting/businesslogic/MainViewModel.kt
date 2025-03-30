package it.reply.unitotesting.businesslogic

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    fun execute(operation: Operation): ResultModel{
        return ResultModel("TODO", Color.Black)
    }

    /**
     *
     *
     *  Non modificare il codice da qui in basso
     *
     * **/

    private val _isAmountMenuExpanded = mutableStateOf(false)
    val isAmountMenuExpanded: MutableState<Boolean> = _isAmountMenuExpanded

    companion object{
        const val DIV_ZERO_ERROR = "Non puoi dividere per 0"
        const val WRONG_FORMAT_ERROR = "Controlla il formato degli operandi"
        const val NULL_OPERATOR = "Imposta un operatore"
    }

}