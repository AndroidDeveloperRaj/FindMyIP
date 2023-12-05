package com.example.mylibrary.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylibrary.model.FindMyIpModel
import com.example.mylibrary.utils.ApiState
import com.example.mylibrary.viewmodels.FindMyIPViewModel
import java.lang.reflect.Field

@Composable
fun ShowIpScreen() {
    val viewModel = viewModel(modelClass = FindMyIPViewModel::class.java)
    when (val result = viewModel.response.value) {
        is ApiState.Success -> {
            IpItems(result.data)
        }

        is ApiState.Failure -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${result.msg}",
                    textAlign = TextAlign.Center
                )
            }
        }

        ApiState.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
            )
        }

        ApiState.Empty -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Data is empty!!",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun IpItems(findMyIp: FindMyIpModel) {
    val modelClass: Class<*> = findMyIp.javaClass
    val fields: Array<Field> = modelClass.declaredFields
    Column(modifier = Modifier.padding(10.dp)) {
        for (field in fields) {
            var fieldName = ""
            var value: Any? = ""
            try {
                field.isAccessible = true
                fieldName = field.name
                value = field.get(findMyIp)
                // Do something with the field name and its value
                println("Field: $fieldName, Value: $value")
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
            Text(text = "$fieldName : $value", fontSize = 16.sp)
        }
    }
}