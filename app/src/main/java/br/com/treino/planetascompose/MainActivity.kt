package br.com.treino.planetascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.treino.planetascompose.models.Planets
import br.com.treino.planetascompose.ui.theme.PlanetasComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetasComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    val planets = listOf<Planets>(
                        Planets(name = "Mercurio",
                            description = "Planeta mais proximo do sol",
                            R.drawable.mercurio),
                        Planets(name = "Venus",
                            description = "Segundo planeta do sistema solar",
                            R.drawable.venus),
                        Planets(name = "Terra",
                            description = "Planeta mais dahora, nosso lar",
                            R.drawable.terra),
                        Planets(name = "Marte",
                            description = "Nosso futuro lar, mas tem um pózinho chato",
                            R.drawable.marte),
                        Planets(name = "Jupiter",
                            description = "Planeta gigante e vive com tornadin",
                            R.drawable.jupiter),
                        Planets(name = "Saturno",
                            description = "Tem um anel irado",
                            R.drawable.saturno),
                        Planets(name = "Urano",
                            description = "Penultimo e tem um azul bonitin",
                            R.drawable.urano),
                        Planets(name = "Netuno",
                            description = "Chove diamante, mt style",
                            R.drawable.netuno),
                    )

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "ListPlanets") {
                        composable("ListPlanets") {
                            initScreen(navController = navController,
                                planets = planets)
                        }
                        composable("DetailPlanet") {
                            val planet = navController
                                .previousBackStackEntry?.savedStateHandle?.get<Planets>("planet")

                            planet?.let {
                                screenDetail(planet = it)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun initScreen(navController: NavHostController, planets: List<Planets>) {

        LazyColumn {
            itemsIndexed(planets) { index, item ->
                myCard(navController, planets = planets[index])
            }
        }

    }

    @Composable
    fun myCard(navController: NavHostController, planets: Planets) {
        Row(
            modifier = Modifier
                .padding(15.dp)
                .clickable {
                    navController.currentBackStackEntry?.savedStateHandle?.set("planet", planets)

                    navController.navigate("DetailPlanet")
                },
            verticalAlignment = Alignment.Top
        )
        {
            Card(
                elevation = 10.dp,
                shape = RoundedCornerShape(15.dp),
                border = BorderStroke(2.dp, Color(0x77f5f5f5)),
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .padding(5.dp)

            ) {
                Row {
                    Image(painter = painterResource(id = planets.image),
                        contentDescription = "",
                        Modifier
                            .requiredSize(130.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = planets.name,
                            fontSize = 30.sp)
                    }
                }
            }
        }
    }
}


