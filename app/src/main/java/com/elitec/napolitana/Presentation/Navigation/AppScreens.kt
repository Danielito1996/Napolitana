package com.elitec.pizza.Presentation.Navigation

sealed class AppScreens(val route: String) {
	object FirstScreen: AppScreens("FirstScreen")
	object MenuScreen: AppScreens("MenuScreen")
	object OfertasScreen: AppScreens("OfertasScreen")
	object PedidosScreen: AppScreens("PedidosScreen")
	object ConfiguracionScreen: AppScreens("ConfiguracionScreen")
}