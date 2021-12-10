package com.fajarazay.github.composestarbuck.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.fajarazay.github.composestarbuck.data.PromoData
import com.fajarazay.github.composestarbuck.ui.component.ButtonSocialMedia
import com.fajarazay.github.composestarbuck.ui.component.CarouselIndicator
import com.fajarazay.github.composestarbuck.ui.component.InputField
import com.fajarazay.github.composestarbuck.ui.component.SpannableText
import com.fajarazay.github.composestarbuck.ui.theme.*
import com.fajarazay.github.composestarbuck.utils.AnnotatedStringTextSpannable
import com.fajarazay.github.composestarbuck.utils.rememberPagerState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@ExperimentalPagerApi
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStarBuckTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ContentLoginPage()
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun ContentLoginPage() {
    val emoji = "\uD83D\uDC4B"

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            ) {
            Column() {
                Text(
                    "Good Morning, $emoji",
                    style = TextStyle(
                        color = GreyLight,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                    )
                )
                Text(
                    "Welcome back!",
                    style = TextStyle(
                        color = Black,
                        fontWeight = FontWeight.Black,
                        fontSize = 21.sp,
                    )
                )
            }
            Image(painter = painterResource(id = R.drawable.icon), contentDescription = null)
        }


        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = ColorPrimary)) {
                    append("Starbucks")
                }
                append(" ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Black
                    )
                ) {
                    append("Promotion")
                }
            },
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        PromoCarousel()

        InputField(
            hintText = "Email", modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp)
        )

        InputField(
            hintText = "Password",
            inputType = "password",
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                RadioButtonKeepLogin()
                Text(
                    text = "Keep me logged in",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            Text(
                text = "Forgot Password?", style = TextStyle(
                    color = ColorPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }

        Button(
            onClick = { /*TODO*/},
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ColorPrimary
            ),
            shape = RoundedCornerShape(70.dp)

        ) {
            Text(
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                text = "Login", color = Color.White
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Divider(color = BlackAlpha49, thickness = 2.dp, modifier = Modifier.width(100.dp))
            Text(
                text = "OR", modifier = Modifier.padding(horizontal = 30.dp),
                style = TextStyle(
                    fontSize = 17.sp,
                    color = BlackAlpha49,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Divider(color = BlackAlpha49, thickness = 2.dp, modifier = Modifier.width(100.dp))
        }

        ButtonSocialMedia(
            icon = R.drawable.ic_facebook,
            textButton = "Login with Facebook",
            backgroundColor = BlueFacebook,
            textColor = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        ButtonSocialMedia(
            icon = R.drawable.ic_google,
            textButton = "Login with Google",
            backgroundColor = Color.White,
            borderColor = Color.Black,
            textColor = Color.Black
        )
        Spacer(modifier = Modifier.height(24.dp))
        SignupClickableText()
    }
}

@Composable
fun SignupClickableText() {
    val context = LocalContext.current

    val tagAnnotation = "Signup"
    val annotatedString = AnnotatedStringTextSpannable.setAnnotatedString(
        firstAppend = "Don’t have an account?",
        tagAnnotation = tagAnnotation, secondAppend = " Sign Up"
    )
    SpannableText(annotatedText = annotatedString, tag = tagAnnotation, onClick = {

    })
}

@ExperimentalPagerApi
@Composable
fun PromoCarousel() {
    Surface(modifier = Modifier.fillMaxWidth()) {

        val items = ArrayList<PromoData>()

        items.add(
            PromoData(
                image = R.drawable.promo_1
            )
        )
        items.add(
            PromoData(
                image = R.drawable.promo_2
            )
        )
        items.add(
            PromoData(
                image = R.drawable.promo_3
            )
        )

        val pagerState = rememberPagerState(
            pageCount = items.size,
            initialOffscreenLimit = 2,
            infiniteLoop = true,
            initialPage = 0,
        )

        LaunchedEffect(Unit) {
            while (true) {
                yield()
                delay(2000)
                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                    animationSpec = tween(600)
                )
            }
        }

        PromoViewPager(
            item = items, pagerState = pagerState
        )

    }
}

@Composable
fun RadioButtonKeepLogin() {
    val isSelected = remember {mutableStateOf(false)}
    RadioButton(
        selected = isSelected.value, onClick = {
            isSelected.value = !isSelected.value
        },
        modifier = Modifier.size(20.dp),
        colors = RadioButtonDefaults.colors(
            selectedColor = ColorPrimary
        )
    )
}

@ExperimentalPagerApi
@Composable
fun PromoViewPager(
    item: List<PromoData>,
    pagerState: PagerState,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            dragEnabled = false
        ) {page ->
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = item[page].image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(132.dp)
                        .width(190.dp)
                )
            }
        }

        CarouselIndicator(
            item.size,
            pagerState.currentPage
        )
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStarBuckTheme {
        ContentLoginPage()
    }
}
