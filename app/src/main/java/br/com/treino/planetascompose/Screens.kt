package br.com.treino.planetascompose

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.Navigation
import br.com.treino.planetascompose.models.Planets
import java.time.format.TextStyle

@Composable
fun screenDetail(planet: Planets) {
    Row(
        verticalAlignment = Alignment.Top
    )
    {

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(top = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = planet.image),
                contentDescription = "",
                Modifier
                    .requiredSize(300.dp),
                contentScale = ContentScale.Crop
            )
            Row(Modifier
                .fillMaxWidth()
                .padding(top = 8.dp), Arrangement.Center) {
                Text(
                    text = planet.name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green)
            }
            Column(Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
                Arrangement.Top,
                Alignment.CenterHorizontally) {
                Text(
                    text = planet.description,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green)
            }

        }
    }
}