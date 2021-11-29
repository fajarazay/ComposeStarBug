package com.fajarazay.github.composestarbuck.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.fajarazay.github.composestarbuck.ui.login.LoginActivity
import com.fajarazay.github.composestarbuck.ui.theme.ColorPrimary
import com.fajarazay.github.composestarbuck.ui.theme.ComposeStarBuckTheme
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
                    onboardingContent()
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun onboardingContent() {
    Surface(modifier = Modifier.fillMaxSize()) {

        val items = ArrayList<OnBoardingData>()

        items.add(
            OnBoardingData(
                R.drawable.img_onboarding_first,
                "Good Cofffe \n" +
                        "Good Moods",
                "“To inspire and nurture the human spirit–one person, one cup and one neighborhood at a time.”"
            )
        )

        items.add(
            OnBoardingData(
                R.drawable.img_onboarding_second,
                "Starbucks Frappucino Work can wait",
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
@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    ComposeStarBuckTheme {
        onboardingContent()
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
                                        append(item[page].title.split("Frappucino").first())
                                    }
                                    append("Frappucino")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                    ) {
                                        append(item[page].title.split("Frappucino").last())
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

            PagerIndicator(item.size, pagerState.currentPage)
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = ColorPrimary,
                ),
                onClick = { /*TODO*/},
                modifier = Modifier
                    .padding(top = 24.dp)
                    .clip(RoundedCornerShape(16.dp))

            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    text = "Get Started", color = Color.White,
                    style = TextStyle(
                        fontSize = 22.sp
                    )
                )
            }

            LoginClickableText()
        }
    }
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @androidx.annotation.IntRange(from = 0) pageCount: Int,
    @androidx.annotation.IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @androidx.annotation.IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(saver = PagerState.Saver) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

@Composable
fun PagerIndicator(size: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(top = 24.dp)
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) ColorPrimary else Color(0xFF979797)
            )
    )
}

@Composable
fun LoginClickableText() {
    val context = LocalContext.current

    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Gray,
            )
        ) {
            append("Already have an account?")

        }
        pushStringAnnotation(
            tag = "Login",// provide tag which will then be provided when you click the text
            annotation = "Login"
        )
        //add text with your different color/style
        withStyle(
            style = SpanStyle(
                color = ColorPrimary,
            )
        ) {
            append(" Log In")
        }
        // when pop is called it means the end of annotation with current tag
        pop()
    }

    ClickableText(
        modifier = Modifier.padding(vertical = 32.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        ),
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "Login",// tag which you used in the buildAnnotatedString
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                Toast.makeText(context, "$annotation.item", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context, LoginActivity::class.java))
            }
        }
    )
}
