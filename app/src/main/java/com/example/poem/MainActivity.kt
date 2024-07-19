package com.example.poem

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.poem.ui.theme.PoemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PoemTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PoemImage(
                        title = stringResource(R.string.poem_title),
                        author = stringResource(R.string.poem_author),
                        date = stringResource(R.string.poem_date),
                        content = "The biggest joy when living is being yourself.\n"+
                                "Nothing stops you from being yourself.\n" +
                                "This lure is much stronger than spending money, or having sex, or getting understood by others.\n" +
                                "This course is all about yourself. It’s self-content.\n" +
                                "It’s like you know every inch about yourself,\n" +
                                "Or you’re on the journey to discover yourself.\n" +
                                "You’re the whole of yourself.\n"+
                                "You don’t need to broadcast to the rest of the world.\n" +
                                "More specific, you’re craving, longing to do the things that make you feel who you really are.\n" +
                                "If anything gets in the way, you are unrestful.\n" +
                                "\n" +
                                "You’re walking.\n" +
                                "You’re climbing.\n" +
                                "You’re fighting.\n" +
                                "You’re in pain.\n" +
                                "Until your craving is satisfied.\n"
                    )



                }
            }
        }
    }
}

@Composable
fun PoemText(title: String, author: String, date: String, content: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 120.dp, bottom = 6.dp, start = 90.dp)
        )
        Text(
            text = author,
            fontSize = 14.sp,
            //textAlign = TextAlign.Center The center is not working, I use start padding instead
            modifier = Modifier.padding(start = 150.dp)
        )
        Text(
            text = date,
            fontSize = 14.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(
                    top =10.dp,
                    end = 18.dp
                )
                .align(alignment = Alignment.End)
        )
        Text(
            text = content,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 46.dp)
        )
    }
}

@Composable
fun PoemImage(
    title: String,
    author: String,
    date: String,
    content: String,
    modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.pearflower)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(950.dp),//again, 900dp doesn't fit the bottom of the screen so increased to 950dp
            alpha = 0.92F//这个是alpha通道，透明度
            )
        PoemText(
            title = title,
            author = author,
            date = date,
            content = content)
    }
}

