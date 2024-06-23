package com.elitec.pizza.Presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.elitec.napolitana.Presentation.theme.NaranjaBeich
import com.elitec.napolitana.R
import com.elitec.pizza.Presentation.Navigation.AppScreens
import com.elitec.pizza.Presentation.Navigation.TapNavigator
import com.elitec.pizza.Presentation.ViewModels.PedidosViewModel

@Composable
fun MenuScreen(navController: NavController) {
	val sharedNavController = rememberNavController()
	val viewModel:PedidosViewModel= hiltViewModel()
	val configuracion = LocalConfiguration.current
	val pantallaHorizontal = configuracion.orientation==Configuration.ORIENTATION_LANDSCAPE
	Box(modifier = Modifier.fillMaxSize()) {
		if (pantallaHorizontal) {
			Row {
				Box(modifier = Modifier
					.fillMaxWidth()
					.weight(1f)) {
					//Botton Bar
					BotomBar(sharedNavController,viewModel,pantallaHorizontal)
				}
				Box(modifier = Modifier
					.fillMaxWidth()
					.weight(9f)) {
					TapNavigator(sharedNavController,viewModel)
				}
			}
		}
		else {
			Column {
				Box(modifier = Modifier
					.fillMaxWidth()
					.weight(9f)) {
					TapNavigator(sharedNavController,viewModel)
				}
				Box(modifier = Modifier
					.fillMaxWidth()
					.weight(1f)) {
					//Botton Bar
					BotomBar(sharedNavController,viewModel,pantallaHorizontal)
				}
			}
		}
	}
}

@Composable
fun TargetaPlatosPrincipales(viewModel: PedidosViewModel) {
	Surface(shape = RoundedCornerShape(20.dp),tonalElevation = 5.dp,
		shadowElevation = 3.dp,
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.padding(start = 10.dp, top = 10.dp, end = 10.dp)) {
		Box(contentAlignment = Alignment.BottomCenter,
			modifier = Modifier.fillMaxWidth()){
			Box(modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight()) {
				Image(painter = painterResource(id = R.drawable.pizzaqueso) ,
					contentDescription = null,
					contentScale = ContentScale.Crop,
					modifier = Modifier.fillMaxWidth())
			}
			Surface(tonalElevation = 5.dp,
				shadowElevation = 3.dp,
				shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
				modifier = Modifier.fillMaxWidth()) {
				Column {
					Row(
						horizontalArrangement = Arrangement.SpaceBetween,
						verticalAlignment = Alignment.CenterVertically,
						modifier = Modifier
							.fillMaxWidth()
							.padding(10.dp)
					) {
						Text(
							text = "Pizza de Queso especial",
							fontSize = 20.sp,
							fontWeight = FontWeight.Bold
						)
						Row(
							verticalAlignment = Alignment.CenterVertically,
							horizontalArrangement = Arrangement.Center,
							modifier = Modifier
						) {
							Text(text = "73.2", fontSize = 20.sp,fontWeight = FontWeight.Bold)
							Text(text = " $", fontSize = 20.sp, fontWeight = FontWeight.Bold)
						}
					}
					Divider(modifier = Modifier.padding(start =5.dp,end =5.dp, bottom = 5.dp))
					Text(textAlign = TextAlign.Justify,text = "Al mas puro estilo italiano, queso, harina de la mas alta calidad y productos de primera calidad aseguran un gusto exquisito",
						modifier = Modifier.padding(start = 14.dp, end = 14.dp))
					Button(colors = ButtonDefaults
						.buttonColors(containerColor = Color.Transparent),
						onClick = { viewModel.AgregarProducto() },
						modifier = Modifier
							.fillMaxWidth()
							.padding(start = 14.dp, bottom = 5.dp, end = 14.dp)) {
						Surface(tonalElevation = 5.dp,
							shadowElevation = 3.dp,color = Color(0xFF5DDC54),
							shape = RoundedCornerShape(10.dp),
							modifier = Modifier.fillMaxWidth()) {
							Row(verticalAlignment = Alignment.CenterVertically,
								horizontalArrangement = Arrangement.SpaceAround,
								modifier = Modifier.padding(top = 7.dp, bottom = 7.dp)) {
								Text(text = "AÑADIR AL PEDIDO",
									color = Color.Black,
									fontSize = 15.sp)
								Icon(imageVector = Icons.Filled.ShoppingCart,
									tint = Color.Black,
									contentDescription = null)
							}
						}
					}
				}
			}
		}
	}
}
/*
@Composable
fun BotomBar(navHostController: NavHostController, viewModel: PedidosViewModel) {
	var paginaActual by rememberSaveable { mutableStateOf("OfertasScreen") }

	Surface(
		color = NaranjaBeich,
		tonalElevation = 5.dp,
		shadowElevation = 3.dp,
		shape = RoundedCornerShape(15.dp),
		modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(10.dp)
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Center,
			modifier = Modifier.fillMaxWidth()
		) {
			// Botón de pedidos
			Button(
				onClick = {
					if (paginaActual != "PedidosOfertasScreen") {
						paginaActual = "PedidosScreen"
					}
				},
				colors = ButtonDefaults.textButtonColors(
					containerColor = Color.Transparent,
					contentColor = Color.Black
				),
				modifier = Modifier.weight(8f)
			) {
				// Contenido del botón
			}

			// Botón de ofertas
			Button(
				onClick = {
					if (paginaActual != "OfertasScreen") {
						paginaActual = "OfertasScreen"
					}
				},
				colors = ButtonDefaults.textButtonColors(
					containerColor = Color.Transparent,
					contentColor = Color.Black
				),
				modifier = Modifier.weight(8f)
			) {
				// Contenido del botón
			}

			// Botón de configuración
			Button(
				onClick = {
					if (paginaActual != "ConfiguracionScreen") {
						// Lógica de navegación
					}
				},
				colors = ButtonDefaults.textButtonColors(
					containerColor = Color.Transparent,
					contentColor = Color.Black
				),
				modifier = Modifier.weight(8f)
			) {
				// Contenido del botón
			}
		}
	}
}
*/


@Composable
fun BotomBar(navHostController: NavHostController,viewModel:PedidosViewModel, isHorizontal: Boolean) {
	//val navBackStackEntry by navHostController.currentBackStackEntryAsState()
	//val currentRoute = navBackStackEntry?.destination?.route
	var counter by rememberSaveable {
		mutableStateOf(0)}
	counter=viewModel.couter
	var paginaActual by rememberSaveable {
		mutableStateOf("OfertasScreen")
	}
	Surface(color = NaranjaBeich,tonalElevation = 5.dp,
		shadowElevation = 3.dp,
		shape = RoundedCornerShape(15.dp),
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.padding(10.dp)) {
		}
	 	if (isHorizontal) {
			Column(verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier.fillMaxWidth()) {
				Column(verticalArrangement = Arrangement.Center,
					horizontalAlignment = Alignment.CenterHorizontally,
					modifier = Modifier.weight(3f)) {
					Button(
						onClick = {
							if (paginaActual != "PedidosOfertasScreen") {
								navHostController.navigate(AppScreens.PedidosScreen.route)
								paginaActual = "PedidosScreen"
							}
						},
						colors = ButtonDefaults
							.textButtonColors(
								containerColor = Color.Transparent,
								contentColor = Color.Black
							),
						modifier = Modifier.weight(8f)) {

						Box(contentAlignment = Alignment.Center,
							modifier = Modifier
								.fillMaxWidth()
								.fillMaxHeight()) {
							Icon(painter = painterResource(id = R.drawable.buycart),
								contentDescription = null,
								modifier = Modifier.padding(5.dp))
							Box(contentAlignment = Alignment.TopEnd,modifier = Modifier
								.fillMaxWidth()
								.padding(top = 5.dp)
								.fillMaxHeight()) {
								Surface(tonalElevation = 5.dp,
									shadowElevation = 3.dp,shape = CircleShape, color = Color.Red) {
									Text(fontSize = 14.sp, color = Color.White,text=counter.toString(),
										modifier = Modifier.padding(start = 3.dp, end = 3.dp))
								}
							}
						}
					}
					if (paginaActual=="PedidosScreen") {
						Surface(tonalElevation = 5.dp,
							shadowElevation = 3.dp,shape = RoundedCornerShape(10.dp),modifier = Modifier
								.weight(2f)
								.fillMaxWidth()
								.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
					else {
						Surface(color = Color.Transparent,shape = RoundedCornerShape(10.dp),modifier = Modifier
							.weight(2f)
							.fillMaxWidth()
							.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
				}
				Column(verticalArrangement = Arrangement.Center
					,modifier = Modifier.weight(3f),
					horizontalAlignment = Alignment.CenterHorizontally) {
					Button(
						onClick = {
							if (paginaActual != "OfertasScreen") {
								navHostController.navigate(AppScreens.OfertasScreen.route)
								paginaActual = "OfertasScreen"
							}
						},
						colors = ButtonDefaults
							.textButtonColors(
								containerColor = Color.Transparent,
								contentColor = Color.Black
							),
						modifier = Modifier.weight(8f)
					) {
						Box(contentAlignment = Alignment.Center) {
							Icon(
								painter = painterResource(id = R.drawable.menuicon),
								contentDescription = null,
								modifier = Modifier.padding(5.dp)
							)
						}
					}
					if (paginaActual=="OfertasScreen") {
						Surface(tonalElevation = 5.dp,
							shadowElevation = 3.dp,shape = RoundedCornerShape(10.dp),modifier = Modifier
								.weight(2f)
								.fillMaxWidth()
								.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
					else {
						Surface(color = Color.Transparent,shape = RoundedCornerShape(10.dp),modifier = Modifier
							.weight(2f)
							.fillMaxWidth()
							.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}

				}
				Column(verticalArrangement = Arrangement.Center,
					horizontalAlignment = Alignment.CenterHorizontally,
					modifier = Modifier.weight(3f)) {
					Button(
						onClick = {
							if (paginaActual != "ConfiguracionScreen") {
								navHostController.navigate(AppScreens.ConfiguracionScreen.route)
								paginaActual = "ConfiguracionScreen"
							}
						},
						colors = ButtonDefaults
							.textButtonColors(
								containerColor = Color.Transparent,
								contentColor = Color.Black
							),
						modifier = Modifier.weight(8f)
					) {
						Box(contentAlignment = Alignment.Center) {
							Icon(
								painter = painterResource(id = R.drawable.configuracionicon),
								contentDescription = null,
								modifier = Modifier.padding(5.dp)
							)
						}
					}
					if (paginaActual=="ConfiguracionScreen") {
						Surface(tonalElevation = 5.dp,
							shadowElevation = 3.dp,shape = RoundedCornerShape(10.dp),modifier = Modifier
								.weight(2f)
								.fillMaxWidth()
								.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
					else {
						Surface(color = Color.Transparent,shape = RoundedCornerShape(10.dp),modifier = Modifier
							.weight(2f)
							.fillMaxWidth()
							.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
				}
			}
		}
		else {
			Row(verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center,
				modifier = Modifier.fillMaxWidth()) {
				Column(verticalArrangement = Arrangement.Center,
					horizontalAlignment = Alignment.CenterHorizontally,
					modifier = Modifier.weight(3f)) {
					Button(
						onClick = {
							if (paginaActual != "PedidosOfertasScreen") {
								navHostController.navigate(AppScreens.PedidosScreen.route)
								paginaActual = "PedidosScreen"
							}
						},
						colors = ButtonDefaults
							.textButtonColors(
								containerColor = Color.Transparent,
								contentColor = Color.Black
							),
						modifier = Modifier.weight(8f)) {

						Box(contentAlignment = Alignment.Center,
							modifier = Modifier
								.fillMaxWidth()
								.fillMaxHeight()) {
							Icon(painter = painterResource(id = R.drawable.buycart),
								contentDescription = null,
								modifier = Modifier.padding(5.dp))
							Box(contentAlignment = Alignment.TopEnd,modifier = Modifier
								.fillMaxWidth()
								.padding(top = 5.dp)
								.fillMaxHeight()) {
								Surface(tonalElevation = 5.dp,
									shadowElevation = 3.dp,shape = CircleShape, color = Color.Red) {
									Text(fontSize = 14.sp, color = Color.White,text=counter.toString(),
										modifier = Modifier.padding(start = 3.dp, end = 3.dp))
								}
							}
						}
					}
					if (paginaActual=="PedidosScreen") {
						Surface(tonalElevation = 5.dp,
							shadowElevation = 3.dp,shape = RoundedCornerShape(10.dp),modifier = Modifier
								.weight(2f)
								.fillMaxWidth()
								.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
					else {
						Surface(color = Color.Transparent,shape = RoundedCornerShape(10.dp),modifier = Modifier
							.weight(2f)
							.fillMaxWidth()
							.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
				}
				Column(verticalArrangement = Arrangement.Center
					,modifier = Modifier.weight(3f),
					horizontalAlignment = Alignment.CenterHorizontally) {
					Button(
						onClick = {
							if (paginaActual != "OfertasScreen") {
								navHostController.navigate(AppScreens.OfertasScreen.route)
								paginaActual = "OfertasScreen"
							}
						},
						colors = ButtonDefaults
							.textButtonColors(
								containerColor = Color.Transparent,
								contentColor = Color.Black
							),
						modifier = Modifier.weight(8f)
					) {
						Box(contentAlignment = Alignment.Center) {
							Icon(
								painter = painterResource(id = R.drawable.menuicon),
								contentDescription = null,
								modifier = Modifier.padding(5.dp)
							)
						}
					}
					if (paginaActual=="OfertasScreen") {
						Surface(tonalElevation = 5.dp,
							shadowElevation = 3.dp,shape = RoundedCornerShape(10.dp),modifier = Modifier
								.weight(2f)
								.fillMaxWidth()
								.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
					else {
						Surface(color = Color.Transparent,shape = RoundedCornerShape(10.dp),modifier = Modifier
							.weight(2f)
							.fillMaxWidth()
							.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}

				}
				Column(verticalArrangement = Arrangement.Center,
					horizontalAlignment = Alignment.CenterHorizontally,
					modifier = Modifier.weight(3f)) {
					Button(
						onClick = {
							if (paginaActual != "ConfiguracionScreen") {
								navHostController.navigate(AppScreens.ConfiguracionScreen.route)
								paginaActual = "ConfiguracionScreen"
							}
						},
						colors = ButtonDefaults
							.textButtonColors(
								containerColor = Color.Transparent,
								contentColor = Color.Black
							),
						modifier = Modifier.weight(8f)
					) {
						Box(contentAlignment = Alignment.Center) {
							Icon(
								painter = painterResource(id = R.drawable.configuracionicon),
								contentDescription = null,
								modifier = Modifier.padding(5.dp)
							)
						}
					}
					if (paginaActual=="ConfiguracionScreen") {
						Surface(tonalElevation = 5.dp,
							shadowElevation = 3.dp,shape = RoundedCornerShape(10.dp),modifier = Modifier
								.weight(2f)
								.fillMaxWidth()
								.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
					else {
						Surface(color = Color.Transparent,shape = RoundedCornerShape(10.dp),modifier = Modifier
							.weight(2f)
							.fillMaxWidth()
							.padding(start = 25.dp, bottom = 10.dp, end = 25.dp)) {

						}
					}
				}
			}
		}
	}



@Composable
fun OfertasDelaCasa() {
	Surface(tonalElevation = 5.dp,
		shadowElevation = 3.dp,color = NaranjaBeich,shape= RoundedCornerShape(20.dp),
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.padding(5.dp)) {
		Row {
			Column(modifier = Modifier.weight(7f)) {
				Text(text = "50%",
					color = Color.Black,
					fontSize = 40.sp,
					fontFamily = FontFamily.Serif,
					modifier = Modifier
						.weight(3f)
						.padding(start = 15.dp))
				Text(text = "Si consumes mas de 5 productos de mas de 300 CUP, se llevara el 50% de descuento de la primero",
					textAlign = TextAlign.Justify,
					color = Color.Black,
					modifier = Modifier
						.weight(5f)
						.padding(start = 15.dp, end = 10.dp))
				Row(verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.Center,
					modifier = Modifier
						.weight(2f)
						.fillMaxWidth()) {
					Icon(imageVector = Icons.Filled.Star,
						tint = Color.Black,
						contentDescription = null)
					Icon(imageVector = Icons.Filled.Star,
						tint = Color.Black,
						contentDescription = null)
					Icon(imageVector = Icons.Filled.Star,
						tint = Color.Black,
						contentDescription = null)
					Icon(imageVector = Icons.Filled.Star,
						tint = Color.Black,
						contentDescription = null)
					Icon(imageVector = Icons.Filled.Star,
						tint = Color.Black,
						contentDescription = null)
				}
			}
			Image(contentScale = ContentScale.Crop,
				painter = painterResource(id = R.drawable.pizzaofertas2),
				contentDescription = "Ofertas",
				modifier = Modifier
					.weight(3f)
					.clip(shape = RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp)))

		}
	}
}

@Composable
fun EnlacesRapidos() {
	val colorfondo=if (isSystemInDarkTheme()) {Color(0xFF2D2D30)} else {Color(0xFFEDEDEF)}
	LazyRow(
		horizontalArrangement = Arrangement.Center,
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier
			.padding(top =20.dp, bottom = 20.dp)
	) {
		item {
			Surface( tonalElevation = 5.dp,
				shadowElevation = 3.dp,
				color = colorfondo ,
				shape = RoundedCornerShape(15.dp),
				modifier = Modifier
					.fillMaxHeight()
					.padding(start = 10.dp, end = 10.dp, top = 5.dp)
			) {
				Row(verticalAlignment = Alignment.CenterVertically) {
						Image(painter = painterResource(id = R.drawable.pizzacoloreada),
							contentDescription = null,
							modifier = Modifier.padding(start =  10.dp))
						Text(
							text = "PIZZAS",
							fontFamily = FontFamily.Serif,
							fontSize = 20.sp,
							modifier = Modifier.padding(start = 5.dp, end = 15.dp)
						)

				}
			}
		}
		item {
			Surface(tonalElevation = 5.dp,
				shadowElevation = 3.dp,
				color = colorfondo,
				shape = RoundedCornerShape(15.dp),
				modifier = Modifier
					.fillMaxHeight()
					.padding(start = 10.dp, end = 10.dp, top = 5.dp)
			) {
				Row(verticalAlignment = Alignment.CenterVertically) {
					Image(painter = painterResource(id = R.drawable.helado_coloreado),
						contentDescription = null,
						modifier = Modifier.padding(start =  10.dp))
					Text(
						text = "POSTRES Y HELADOS",
						fontFamily = FontFamily.Serif,
						fontSize = 20.sp,
						modifier = Modifier.padding(start = 5.dp, end = 15.dp)
					)

				}
			}
		}
		item {
			Surface(tonalElevation = 5.dp,
				shadowElevation = 3.dp,
				color = colorfondo,
				shape = RoundedCornerShape(15.dp),
				modifier = Modifier
					.fillMaxHeight()
					.padding(start = 10.dp, end = 10.dp, top = 5.dp)
			) {
				Row(verticalAlignment = Alignment.CenterVertically) {
					Image(painter = painterResource(id = R.drawable.cervezacoloreada),
						contentDescription = null,
						modifier = Modifier.padding(start =  10.dp))
					Text(
						text = "BEBIDAS ALCOHOLICAS",
						fontFamily = FontFamily.Serif,
						fontSize = 20.sp,
						modifier = Modifier.padding(start = 5.dp, end = 15.dp)
					)

				}
			}
		}
		item {
			Surface(tonalElevation = 5.dp,
				shadowElevation = 3.dp,
				color = colorfondo,
				shape = RoundedCornerShape(15.dp),
				modifier = Modifier
					.fillMaxHeight()
					.padding(start = 10.dp, end = 10.dp, top = 5.dp)
			) {
				Row(verticalAlignment = Alignment.CenterVertically) {
					Image(painter = painterResource(id = R.drawable.limoadacoloreada),
						contentDescription = null,
						modifier = Modifier.padding(start =  10.dp))
					Text(
						text = "BEBIDAS REFRESCANTES",
						fontFamily = FontFamily.Serif,
						fontSize = 20.sp,
						modifier = Modifier.padding(start = 5.dp, end = 15.dp)
					)

				}
			}
		}
	}
}


@Composable
fun CuadroDeBusqueda() {
	val colorTextField = if (isSystemInDarkTheme()) {
		Color.White
	}
	else {
		Color.Black
	}
	OutlinedTextField(shape = RoundedCornerShape(10.dp),
		value = "",
		onValueChange = {},
		label = {
				Row(verticalAlignment = Alignment.CenterVertically) {
					Icon(imageVector = Icons.Filled.Search,
						tint = colorTextField,
						contentDescription = "Icon Search")
					Text(text = "Busca el producto de su preferencia",
						color = colorTextField, fontSize = 15.sp)
				}
		},
		modifier = Modifier
			.fillMaxWidth()
			.padding(5.dp))
}


@Preview
@Composable
fun MenuScreenPreview() {
	val navController = rememberNavController()
	MenuScreen(navController = navController)
}