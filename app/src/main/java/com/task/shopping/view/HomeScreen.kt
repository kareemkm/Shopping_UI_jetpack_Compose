package com.task.shopping.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.task.shopping.R

@Composable
fun HomeScreen(navController: NavController) {

    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(Color(0xFFFAFAFA))
            .padding(horizontal = 10.dp, vertical = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 30.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = "Bonjour \uD83D\uDC4B\uD83C\uDFFB",
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Kareem",
                    color = Color.Black,
                )
            }
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(Color.Gray)
                    .size(50.dp)
            ) {

            }
        }
        Text(
            text = "Vos idées d’achat",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    FourItems(
                        modifier = Modifier.weight(1f),
                        color = Color(0xFFDBDAF7),
                        image = painterResource(R.drawable.icon1),
                        title = "Scanner un produit",
                        titleNumber = "384 Scannés"
                    )
                    FourItems(
                        modifier = Modifier.weight(1f),
                        color = Color(0xFFCCE7E5),
                        image = painterResource(R.drawable.icon3),
                        title = "Produits achetés",
                        titleNumber = "164 achats"
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    FourItems(
                        modifier = Modifier.weight(1f),
                        color = Color(0xFFF6E3DB),
                        image = painterResource(R.drawable.icon2),
                        title = "Contrefaçons",
                        titleNumber = "23 détectées"
                    )
                    FourItems(
                        modifier = Modifier.weight(1f),
                        color = Color(0xFFB0EDF3),
                        image = painterResource(R.drawable.icon4),
                        title = "Liste de souhaits",
                        titleNumber = "258 articles"
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Découvrez plus",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )
        }


        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(images) { image ->
                Box(modifier = Modifier
                    .size(150.dp)
                    .padding(5.dp)) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

    }

}

@Composable
fun TopBar() {

}

@Composable
fun FourItems(
    modifier: Modifier,
    color: Color,
    image: Painter,
    title: String,
    titleNumber: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF7EFEE)),
        contentAlignment = Alignment.Center

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color),
                contentAlignment = Alignment.Center

            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                )
            }

            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 15.dp)
            )
            Text(
                text = titleNumber,
                fontSize = 10.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
