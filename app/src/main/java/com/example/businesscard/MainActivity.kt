package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Color(0xFF67eece))
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box {
        }
        Column() {
            val image: Painter = painterResource(R.drawable.logo)
            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier
                    .background(color = Color.Black)
                    .fillMaxWidth(0.28F)
                    .align(Alignment.CenterHorizontally)
            )
            TextCenter(text = stringResource(R.string.name), fontSize = 35.sp)
            TextCenter(text = stringResource(R.string.job), fontColor = Color(0xff21901f))
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            Row {
                val callIcon: Painter = painterResource(R.drawable.icon_call)
                ContactInfo(icon = callIcon, info = stringResource(R.string.phone))
            }
            Row {
                val shareIcon: Painter = painterResource(R.drawable.share)
                ContactInfo(icon = shareIcon, info = stringResource(R.string.at))
            }
            Row{
                val emailIcon: Painter = painterResource(R.drawable.icon_email)
                ContactInfo(icon = emailIcon, info = stringResource(R.string.email))
            }
        }
    }

}

@Composable
fun ContactInfo(
    icon: Painter,
    info: String,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = icon,
        contentDescription = null,
        tint = Color(0xff21901f),
        modifier = modifier
            .height(23.dp)
            .padding(start = 100.dp)
    )
    TextCenter(info, textAlign = TextAlign.Left, modifier = modifier.padding(start = 30.dp, bottom = 25.dp))
}

@Composable
fun TextCenter(
    text: String,
    modifier: Modifier = Modifier,
    fontColor: Color = Color.Black,
    fontSize: TextUnit = 15.sp,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth(),
        textAlign = textAlign,
        color = fontColor,
        fontSize = fontSize
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}