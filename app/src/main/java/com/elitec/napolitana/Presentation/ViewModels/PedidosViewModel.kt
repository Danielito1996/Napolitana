package com.elitec.pizza.Presentation.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.elitec.napolitana.Domain.IGenericsFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PedidosViewModel @Inject constructor(private val factory: IGenericsFactory):ViewModel() {
	var couter by mutableStateOf(0)

	fun AgregarProducto() {
		couter++
	}
}