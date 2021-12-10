package com.fajarazay.github.composestarbuck.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.fajarazay.github.composestarbuck.data.OnBoardingData
import com.fajarazay.github.composestarbuck.ui.component.CarouselIndicator
import com.fajarazay.github.composestarbuck.ui.component.SpannableText
import com.fajarazay.github.composestarbuck.ui.login.LoginActivity
import com.fajarazay.github.composestarbuck.ui.theme.ColorPrimary
import com.fajarazay.github.composestarbuck.ui.theme.ComposeStarBuckTheme
import com.fajarazay.github.composestarbuck.utils.AnnotatedStringTextSpannable
import com.fajarazay.github.composestarbuck.utils.rememberPagerState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStarBuckTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OnBoardingContent()
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun OnBoardingContent() {
    Surface(modifier = Modifier.fillMaxSize()) {

        val items = ArrayList<OnBoardingData>()

        items.add(
            OnBoardingData(
                R.drawable.img_onboarding_first,
                "Good Coffee \n" +
                        "Good Moods",
                "“To inspire and nurture the human spirit–one person, one cup and one neighborhood at a time.”"
            )
        )

        items.add(
            OnBoardingData(
                R.drawable.img_onboarding_second,
                "Starbucks Frappuccino Work can wait",
                "“Bring a friend and enjoy a Frappuccino. \n" +
                        "Find stores in your area.”"
            )
        )

        items.add(
            OnBoardingData(
                R.drawable.img_onboarding_third,
                "Morning begins with Tropical Splash Starbucks",
                "“Bring the Fantasy Tail Frappuccino, or treat yourself to the boldly refreshing Peach Cloud with Jelly. “"
            )
        )

        val pagerState = rememberPagerState(
            pageCount = items.size,
            initialOffscreenLimit = 2,
            infiniteLoop = false,
            initialPage = 0,
        )

        OnBoardingPager(
            item = items, pagerState = pagerState, modifier = Modifier
                .fillMaxWidth()
        )

    }
}

@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) {page ->
                Column(
                    modifier = Modifier
                        .padding(top = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.icon),
                        contentDescription = null
                    )

                    Image(
                        painter = painterResource(id = item[page].image),
                        contentDescription = item[page].title,
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    )

                    Text(
                        buildAnnotatedString {
                            when (page) {
                                0 -> {
                                    withStyle(style = SpanStyle(color = ColorPrimary)) {
                                        append(item[page].title.split("\n").first())
                                    }
                                    append("\n")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                    ) {
                                        append(item[page].title.split("\n").last())
                                    }
                                }
                                1 -> {
                                    withStyle(style = SpanStyle(color = ColorPrimary)) {
                                        append(item[page].title.split("Frappuccino").first())
                                    }
                                    append("Frappuccino")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                    ) {
                                        append(item[page].title.split("Frappuccino").last())
                                    }
                                }
                                else -> {
                                    withStyle(style = SpanStyle(color = Color.Black)) {
                                        append(item[page].title.split("Splash").first())
                                    }
                                    append("Splash")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            color = ColorPrimary
                                        )
                                    ) {
                                        append(item[page].title.split("Splash").last())
                                    }
                                }
                            }

                        },
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = item[page].desc,
                        modifier = Modifier.padding(top = 30.dp, start = 16.dp, end = 16.dp),
                        color = Color.Black,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                    )

                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            CarouselIndicator(item.size, pagerState.currentPage)
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = ColorPrimary,
                ),
                onClick = { /*TODO*/},
                modifier = Modifier
                    .padding(top = 24.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(16.dp))

            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    text = "Get Started", color = Color.White,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            LoginClickableText()
        }
    }
}

@ExperimentalPagerApi
@Composable
fun LoginClickableText() {
    val context = LocalContext.current
    val tagAnnotation = "Login"
    val annotatedString = AnnotatedStringTextSpannable.setAnnotatedString(
        firstAppend = "Already have an account?",
        tagAnnotation = tagAnnotation, secondAppend = " Log In"
    )
    SpannableText(annotatedText = annotatedString, tag = tagAnnotation, onClick = {
        context.startActivity(Intent(context, LoginActivity::class.java))
    })
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    ComposeStarBuckTheme {
        OnBoardingContent()
    }
}
