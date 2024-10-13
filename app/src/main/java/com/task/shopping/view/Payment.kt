package com.task.shopping.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.task.shopping.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Payment(navController: NavController){

    var boxSelected by remember { mutableStateOf(true) }
    var creditNumber by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize().background(Color(0xFFFAFAFA))
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 30.dp, horizontal = 15.dp)) {
            Box(
                modifier = Modifier
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp))
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF8F8FB))
                    .clickable {navController.navigate("main") },
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
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Payment \uD83D\uDCB3 ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "12 154 CFA",
                    color = Color(0xFF25D482),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "TVA include (18%)",
                    fontSize = 12.sp,
                    color = Color(0xFFB1B1B1)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 20.dp)
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(15.dp))
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .weight(1f)
                    .clip(if (boxSelected) RoundedCornerShape(15.dp) else RoundedCornerShape(0.dp))
                    .background(if (boxSelected) Color(0xFF25D482) else Color.White)
                    .clickable { boxSelected = true }
                    .padding(horizontal = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(R.drawable.credit_card_icon),
                    contentDescription = null,
                    tint = if (boxSelected) Color.White else Color.Black
                )
                Text(
                    text = "Credit card",
                    color = if (boxSelected) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .weight(1f)
                    .clip(if (!boxSelected) RoundedCornerShape(15.dp) else RoundedCornerShape(0.dp))
                    .background(if (!boxSelected) Color(0xFF25D482) else Color.White)
                    .clickable { boxSelected = false }
                    .padding(22.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(R.drawable.group),
                    contentDescription = null,
                    tint = if (!boxSelected) Color.White else Color.Black
                )
                Text(
                    text = "Mobile Money",
                    color = if (!boxSelected) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp)
        ) {
            Text(
                text = "Numéro de carte",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            OutlinedTextField(
                value = creditNumber,
                onValueChange = {creditNumber = it},
                placeholder = { Text(text = "0000  0000  0000  0000") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF2F2F5),
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedTextColor = Color.Black
                ),
                maxLines = 1,
                shape = RoundedCornerShape(15.dp),
                trailingIcon = {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.master_card_logo),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(R.drawable.card_icon),
                            contentDescription = null
                        )

                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Titulaire",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            OutlinedTextField(
                value = creditNumber,
                onValueChange = {creditNumber = it},
                placeholder = { Text(text = "Lucie AYAH") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF2F2F5),
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedTextColor = Color.Black
                ),
                maxLines = 1,
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Text(
                    text = "Date d'expiration",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "CVV / CVC",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                OutlinedTextField(
                    value = creditNumber,
                    onValueChange = {creditNumber = it},
                    placeholder = { Text(text = "06   /   2024") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color(0xFFF2F2F5),
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedTextColor = Color.Black
                    ),
                    maxLines = 1,
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = creditNumber,
                    onValueChange = {creditNumber = it},
                    placeholder = { Text(text = "000") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color(0xFFF2F2F5),
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedTextColor = Color.Black
                    ),
                    maxLines = 1,
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Nous vous enverrons les détails de la commande à\nvotre adresse e-mail après le paiement réussi.",
                fontSize = 11.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFFB1B1B1),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick ={navController.navigate("successfulPayment")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF25D482)
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(R.drawable.noun_lock_1911126),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(10.dp))
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
}

