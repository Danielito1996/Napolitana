package com.elitec.pizza.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elitec.napolitana.Presentation.theme.NaranjaBeich
import com.elitec.napolitana.Presentation.theme.NaranjaMiel
import com.elitec.napolitana.R
import com.elitec.pizza.Presentation.Navigation.AppScreens

@Composable
fun FirstScreen(navController: NavController) {
	Box(modifier = Modifier
		.fillMaxSize()
		.padding(top = 10.dp)){

		Column(verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier.padding(10.dp)) {
			Box(contentAlignment = Alignment.BottomCenter,
				modifier = Modifier
					.weight(3f)
					.fillMaxWidth()) {
				BannerInicial()
				Surface(shape = CircleShape, color = NaranjaBeich) {
					Image(painter = painterResource(id = R.drawable.log),
						contentDescription = null,
						modifier = Modifier
							.size(90.dp)
							.padding(start = 10.dp, bottom = 10.dp))
				}
			}
			Box(modifier = Modifier
				.weight(2f)
				.fillMaxWidth()) {
				TitulosPersonalizados()
			}
			Box(modifier = Modifier
				.weight(3f)
				.fillMaxWidth()) {
				Promociones(navController)
			}
			Box(contentAlignment = Alignment.BottomCenter,modifier = Modifier
				.weight(2f)
				.fillMaxWidth()) {
				Footer()
			}
		}
	}
}


@Composable
fun Promociones(navController: NavController) {
	Surface(color = NaranjaBeich,
		shape = RoundedCornerShape(15.dp),
		tonalElevation = 5.dp,
		shadowElevation = 3.dp,
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()) {
		Column(verticalArrangement = Arrangement.SpaceEvenly,
			modifier = Modifier
				.fillMaxWidth()
				.padding(10.dp)) {
			Row(
				modifier = Modifier.fillMaxWidth()) {
				Icon(imageVector = Icons.Filled.ShoppingCart,
					contentDescription = null, tint = Color.Black )
				Spacer(modifier = Modifier.width(10.dp))
				Text(text = "10%", color = Color.Black, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif, fontSize = 20.sp)
			}
			Box(modifier = Modifier.fillMaxWidth()){
				Text(textAlign = TextAlign.Justify, color = Color.Black, fontSize = 17.sp,text = "Si en una misma compra se lleva en producto el equivalente a 5000 pesos o superior, entonces descontamos la compra por el 10 % del consto total de la compra, a demas de llevarse un regalo extra")
			}
			val colors = listOf(Color.Red, Color.Yellow, Color.Green)
			val brush = Brush.radialGradient(colors)
			Surface(onClick = { navController.navigate(route = AppScreens.MenuScreen.route) },
				color = NaranjaMiel,shape = RoundedCornerShape(10.dp),tonalElevation = 5.dp,
				shadowElevation = 3.dp,
				modifier = Modifier
					.fillMaxWidth()
					.padding(10.dp)) {
				Row(verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.SpaceBetween,
					modifier = Modifier.fillMaxWidth()) {
					Text(text = "VER OFERTAS",
						color = Color.Black,
						fontFamily = FontFamily.Serif,
						fontSize = 23.sp,
						modifier = Modifier
							.weight(7f)
							.padding(start = 10.dp, top = 10.dp, bottom = 10.dp))
					Icon(imageVector = Icons.Filled.ArrowForward,
						contentDescription = null,
						modifier = Modifier
							.weight(3f)
							.size(30.dp))
				}
			}
		}
	}
}

@Composable
fun TitulosPersonalizados() {
	Column(verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier.fillMaxWidth()) {
		Text(text = "PIZZA BOMBA",
			fontSize = 45.sp,
			fontFamily = FontFamily.Serif)
		Text(text = "...donde el sabor es simplemente explosivo...",
			fontFamily = FontFamily.Cursive,
			fontSize = 20.sp)
		Row {
			Icon(imageVector = Icons.Filled.Star, contentDescription = null)
			Icon(imageVector = Icons.Filled.Star, contentDescription = null)
			Icon(imageVector = Icons.Filled.Star, contentDescription = null)
			Icon(imageVector = Icons.Filled.Star, contentDescription = null)
			Icon(imageVector = Icons.Filled.Star, contentDescription = null)
		}
	}
}

@Composable
fun RedesSociales() {
	Column(modifier = Modifier.fillMaxWidth()) {
		Row(modifier =  Modifier.fillMaxWidth()) {

		}
	}
}

@Composable
fun BannerInicial() {
	Image(contentScale = ContentScale.Crop,
		painter = painterResource(id = R.drawable.foto1),
		contentDescription = null,
		modifier = Modifier
			.fillMaxWidth()
			.padding(bottom = 50.dp)
			.clip(shape = RoundedCornerShape(15.dp)))
}

@Composable
fun Footer() {
	Column {
		Divider(
			Modifier
				.fillMaxWidth()
				.padding(top = 20.dp, bottom = 20.dp, start = 5.dp, end = 5.dp))
		Column(verticalArrangement = Arrangement.Bottom,
			horizontalAlignment = Alignment.CenterHorizontally) {
			Row(verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.SpaceEvenly,
				modifier = Modifier
					.fillMaxWidth()
					.padding(5.dp)) {
				Image(painter = painterResource(id = R.drawable.telegram),
					contentDescription = null,
					modifier = Modifier.size(50.dp))
				Image(painter = painterResource(id = R.drawable.email),
					contentDescription = null,
					modifier = Modifier.size(60.dp))
				Image(painter = painterResource(id = R.drawable.facebook),
					contentDescription = null,
					modifier = Modifier.size(65.dp))
				Image(painter = painterResource(id = R.drawable.web),
					contentDescription = null,
					modifier = Modifier.size(50.dp))
			}
			Text(text = "Design by: ELITEC",
				fontFamily = FontFamily.Serif,
				modifier = Modifier.padding(5.dp))
		}
	}
}

@Preview
@Composable
fun InitialScrenns() {
	val navController = rememberNavController()
	FirstScreen(navController)
}