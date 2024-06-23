package com.elitec.pizza.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elitec.pizza.Presentation.ConfiguracionScreen
import com.elitec.pizza.Presentation.OfertasScreen
import com.elitec.pizza.Presentation.PedidosScreen
import com.elitec.pizza.Presentation.ViewModels.PedidosViewModel


@Composable
fun TapNavigator(navController: NavHostController,viewModel: PedidosViewModel) {
	NavHost(navController = navController, startDestination = AppScreens.OfertasScreen.route) {
		composable(route=AppScreens.OfertasScreen.route) {
			OfertasScreen(navController,viewModel)
		}
		composable(route=AppScreens.ConfiguracionScreen.route) {
			ConfiguracionScreen(navController)
		}
		composable(route=AppScreens.PedidosScreen.route) {
			PedidosScreen(navController)
		}
	}
}