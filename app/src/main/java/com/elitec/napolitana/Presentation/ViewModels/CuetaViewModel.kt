package com.elitec.pizza.Presentation.ViewModels

import androidx.lifecycle.ViewModel
import com.elitec.napolitana.Domain.IGenericsFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CuetaViewModel @Inject constructor(private val factory:IGenericsFactory):ViewModel() {

}