package com.task.shopping.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.task.shopping.R

@Composable
fun Shopping(navController: NavController){

    var countNumberItem by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFAFAFA)).padding(horizontal = 15.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 30.dp, horizontal = 0.dp)) {
            Box(
                modifier = Modifier
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp))
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF8F8FB))
                    .clickable { navController.navigate("main") },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color(0xFFF08F5F),
                    modifier = Modifier.size(50.dp).padding(5.dp)
                )
            }
        }
        Text(
            text = "Votre Panier \uD83D\uDED2 ",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
        ) {
            item {
                ShoppingItem(
                    image = R.drawable.image1,
                    hintText = "FANJUICE",
                    title = "Jus d’Orange Nature",
                    price = "1100 CFA ",
                    count = countNumberItem,
                    onClickPlus = { countNumberItem++ },
                    onClickMinas = { if (countNumberItem != 0) countNumberItem-- })
            }
            item {
                ShoppingItem(
                    image = R.drawable.image1,
                    hintText = "FANJUICE",
                    title = "Jus d’Orange Nature",
                    price = "1100 CFA ",
                    count = countNumberItem,
                    onClickPlus = { countNumberItem++ },
                    onClickMinas = { if (countNumberItem != 0) countNumberItem-- })
            }
            item {
                ShoppingItem(
                    image = R.drawable.image1,
                    hintText = "FANJUICE",
                    title = "Jus d’Orange Nature",
                    price = "1100 CFA ",
                    count = countNumberItem,
                    onClickPlus = { countNumberItem++ },
                    onClickMinas = { if (countNumberItem != 0) countNumberItem-- })
            }
            item {
                ShoppingItem(
                    image = R.drawable.image1,
                    hintText = "FANJUICE",
                    title = "Jus d’Orange Nature",
                    price = "1100 CFA ",
                    count = countNumberItem,
                    onClickPlus = { countNumberItem++ },
                    onClickMinas = { if (countNumberItem != 0) countNumberItem-- })
            }
            item {
                ShoppingItem(
                    image = R.drawable.image1,
                    hintText = "FANJUICE",
                    title = "Jus d’Orange Nature",
                    price = "1100 CFA ",
                    count = countNumberItem,
                    onClickPlus = { countNumberItem++ },
                    onClickMinas = { if (countNumberItem != 0) countNumberItem-- })
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "10300 CFA",
                color = Color(0xFFF08F5F),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {navController.navigate("payment")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF08F5F)
            )
        ) {
            Text(
                text = "Passer à la caisse",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
    }
}

@Composable
fun ShoppingItem(
    image: Int,
    hintText: String,
    title: String,
    price: String,
    count:Int,
    onClickPlus:() -> Unit,
    onClickMinas: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xffF2F2F5))
    ) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxHeight()
                    .width(80.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight().weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = hintText,
                    color = Color(0xFFB1B1B1),
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 13.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = price,
                    color = Color(0xFFF08F5F),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.minas),
                        contentDescription = null,
                        tint = Color(0xFFF08F5F),
                        modifier = Modifier
                            .padding(10.dp)
                            .size(15.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onClickMinas() }
                    )
                    Text(
                        text = count.toString(),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                    Icon(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = null,
                        tint = Color(0xFFF08F5F),
                        modifier = Modifier
                            .padding(10.dp)
                            .size(15.dp)
                            .clickable (
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ){ onClickPlus() }
                    )
                }
            }
        }
    }
}