package com.fajarazay.github.composestarbuck.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fajarazay.github.composestarbuck.R
import com.fajarazay.github.composestarbuck.ui.theme.BlueFacebook

@Composable
fun ButtonSocialMedia(
    icon: Int,
    textButton: String,
    backgroundColor: Color,
    borderColor: Color = backgroundColor,
    textColor: Color
) {
    Button(
        onClick = { /*TODO*/},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 32.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        ),
        shape = RoundedCornerShape(70.dp),
        border = BorderStroke(
            width = 1.dp,
            color = borderColor
        )
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (iconFb, textLoginFb) = createRefs()
            Image(painter = painterResource(id = icon), contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .constrainAs(iconFb) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    })
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = textButton, color = textColor, style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            ),
                modifier = Modifier.constrainAs(textLoginFb) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        }
    }
}

@Preview
@Composable
fun ButtonSocialMediaPreview() {
    ButtonSocialMedia(
        icon = R.drawable.ic_facebook,
        textButton = "Login with Facebook",
        backgroundColor = BlueFacebook,
        textColor = Color.White
    )
}
