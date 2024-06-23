package com.elitec.pizza.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elitec.pizza.Presentation.FirstScreen
import com.elitec.pizza.Presentation.MenuScreen
import com.elitec.pizza.Presentation.ViewModels.PedidosViewModel

@Composable
fun Navigator() {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route) {
		composable(route=AppScreens.FirstScreen.route) {
			FirstScreen(navController)
		}
		composable(route=AppScreens.MenuScreen.route) {
			MenuScreen(navController)
		}
	}
}