package com.fajarazay.github.composestarbuck.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fajarazay.github.composestarbuck.R
import com.fajarazay.github.composestarbuck.ui.theme.ColorPrimary
import com.fajarazay.github.composestarbuck.ui.theme.ComposeStarBuckTheme
import com.fajarazay.github.composestarbuck.ui.theme.Grey

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStarBuckTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Login")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val emoji = "\uD83D\uDC4B"

    val stateEmail = "Email"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column() {
                Text(
                    "Good Morning, $emoji",
                    style = TextStyle(
                        color = Grey,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                    )
                )
                Text(
                    "Welcome back!",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp,
                    )
                )
            }
            Image(painter = painterResource(id = R.drawable.icon), contentDescription = null)
        }


        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = ColorPrimary)) {
                    append("Starbuck")
                }
                append(" ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                ) {
                    append("Promotion")
                }
            },
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 20.dp)
        )

        BasicTextField(
            value = "",
            onValueChange = {},
            decorationBox = {
                Column() {
                    Text(text = "Email")
                    Divider(color = Grey, thickness = 1.dp)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = "",
            onValueChange = {},
            decorationBox = {
                Column() {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Password")
                        Image(
                            painter = painterResource(id = R.drawable.ic_eye_slash),
                            contentDescription = null
                        )
                    }
                    Divider(color = Grey, thickness = 1.dp)
                }

            },
            modifier = Modifier
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                RadioButton(selected = false, onClick = { })
                Text(text = "Keep me logged in")
            }
            Text(text = "Forgot Password?")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStarBuckTheme {
        Greeting("Android")
    }
}
