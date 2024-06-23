package com.elitec.napolitana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elitec.napolitana.Presentation.theme.NapolitanaTheme
import com.elitec.pizza.Presentation.Navigation.Navigator
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			NapolitanaTheme {
				Scaffold(topBar = {StatusBar()}) {it->
					Box(modifier = Modifier
						.fillMaxSize()
						.padding(it))
					{
						if (isSystemInDarkTheme()) {
							Image(contentScale = ContentScale.Crop,
								painter = painterResource(id = R.drawable.fondo_oscuro),
								contentDescription = null,
								modifier = Modifier
									.fillMaxSize()
									.padding(top = 10.dp))
						}
						else {
							Image(contentScale = ContentScale.Crop,
								painter = painterResource(id = R.drawable.fondo_claro),
								contentDescription = null,
								modifier = Modifier
									.fillMaxSize()
									.padding(top = 10.dp))
						}
						Navigator()
					}
				}
			}
		}
	}
}
@Composable
fun StatusBar() {
	Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	NapolitanaTheme {
		Greeting("Android")
	}
}