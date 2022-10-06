package com.example.artspace

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {

    var currentArtImage by remember {
        mutableStateOf(R.drawable.art1)
    }
    var currentArtTitle by remember {
        mutableStateOf(R.string.title1)
    }
    var currentArtist by remember {
        mutableStateOf(R.string.title1_artist)
    }
    var currentArtYear by remember {
        mutableStateOf(R.string.title1_year)
    }

    fun handleClickNext() {
        when (currentArtTitle) {
            R.string.title1 -> {
                currentArtImage = R.drawable.art2
                currentArtTitle = R.string.title2
                currentArtist = R.string.title2_artist
                currentArtYear = R.string.title2_year
            }
            R.string.title2 -> {
                currentArtImage = R.drawable.art3
                currentArtTitle = R.string.title3
                currentArtist = R.string.title3_artist
                currentArtYear = R.string.title3_year
            }
            R.string.title3-> {
                currentArtImage = R.drawable.art1
                currentArtTitle = R.string.title1
                currentArtist = R.string.title1_artist
                currentArtYear = R.string.title1_year
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 30.dp, end = 30.dp, bottom = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(currentArtImage),
            contentDescription = null,
            modifier = Modifier
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp),
                )
                .padding(30.dp)
                .fillMaxWidth()
                .weight(1f)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Card(
            elevation = 3.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = stringResource(currentArtist), fontSize = 30.sp
                )
                Row {
                    Text(
                        text = stringResource(currentArtist),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = stringResource(currentArtYear))
                }
            }
        }
        Spacer(modifier = Modifier.size(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Previous",
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { handleClickNext() },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Next",
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}