package it.reply.unitotesting.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import it.reply.unitotesting.businesslogic.MainViewModel
import it.reply.unitotesting.ui.theme.UniToTestingTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import it.reply.unitotesting.businesslogic.OperationModel
import it.reply.unitotesting.businesslogic.Operator


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel = viewModel()
            UniToTestingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(viewModel,innerPadding)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel, paddingValues: PaddingValues) {

    var firstOperand = remember { mutableStateOf("") }
    var secondOperand = remember { mutableStateOf("") }
    var operator: MutableState<Operator?> = remember { mutableStateOf(null) }

    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Operando 1

        OutlinedTextField(
            value = firstOperand.value,
            label = { Text(text = "Primo operando", color = Color.Black) },
            onValueChange = {
                firstOperand.value = it
            },
        )

        Spacer(Modifier.height(16.dp))

        // Selettore operazione

        Box{
            Button(onClick = {
                viewModel.isAmountMenuExpanded.value = true
            }) {
                Text(text = operator.value?.value ?: "")
                Icon(Icons.Default.ArrowDropDown, contentDescription = "")
            }
            DropdownMenu(expanded = viewModel.isAmountMenuExpanded.value, onDismissRequest = {viewModel.isAmountMenuExpanded.value = false}) {
                DropdownMenuItem(text = { Text(text = Operator.PLUS.value) }, onClick = {
                    viewModel.isAmountMenuExpanded.value = false
                    operator.value = Operator.PLUS
                })
                DropdownMenuItem(text = { Text(text = Operator.MINUS.value) }, onClick = {
                    viewModel.isAmountMenuExpanded.value = false
                    operator.value = Operator.MINUS
                })
                DropdownMenuItem(text = { Text(text = Operator.MUL.value) }, onClick = {
                    viewModel.isAmountMenuExpanded.value = false
                    operator.value = Operator.MUL
                })
                DropdownMenuItem(text = { Text(text = Operator.DIV.value) }, onClick = {
                    viewModel.isAmountMenuExpanded.value = false
                    operator.value = Operator.DIV
                })
            }
            Spacer(Modifier.height(16.dp))
        }

        // Operando 2

        OutlinedTextField(
            value = secondOperand.value,
            label = { Text(text = "Secondo operando", color = Color.Black) },
            onValueChange = { secondOperand.value = it },
        )

        Spacer(Modifier.height(16.dp))

        // Button Conferma

        Box {
            Button(onClick = {viewModel.execute(
                OperationModel(firstOperand.value,secondOperand.value, operator.value)
            )}) {
                Text("Conferma")
            }
        }
        Spacer(Modifier.height(16.dp))

        // Risultato
        Text(viewModel.result.value.result ?: "", color = viewModel.result.value.color)
    }
}