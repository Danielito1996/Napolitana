package com.elitec.pizza.Presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elitec.pizza.Presentation.ViewModels.PedidosViewModel

@Composable
fun OfertasScreen(navController: NavController,viewModel: PedidosViewModel) {
	Box(modifier = Modifier.fillMaxSize()) {
		Column {
			Box(modifier = Modifier
				.fillMaxWidth()
				.padding(start = 5.dp, end = 5.dp)
				.weight(2f)) {
				//Ofertas de la Casa
				OfertasDelaCasa()
			}
			Box(contentAlignment = Alignment.Center,
				modifier = Modifier
					.fillMaxWidth()
					.padding(start = 5.dp, end = 5.dp)
					.weight(1f)) {
				//Cuadro de Busqueda
				CuadroDeBusqueda()
			}
			Box(contentAlignment = Alignment.Center,
				modifier = Modifier
					.fillMaxWidth()
					.padding(start = 5.dp, end = 5.dp)
					.weight(1f)) {
				//Enlaces Rapidos
				EnlacesRapidos()
			}

			Box(modifier = Modifier
				.fillMaxWidth()
				.weight(5f)) {
				//Tarjeta de Platos Principales
				TargetaPlatosPrincipales(viewModel)
			}
		}
	}
}

@Preview
@Composable
fun PizzaScreenPreview() {
	val viewModel:PedidosViewModel= hiltViewModel()
	val navController= rememberNavController()
	OfertasScreen(navController = navController , viewModel)
}