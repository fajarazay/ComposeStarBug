package com.fajarazay.github.composestarbuck.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fajarazay.github.composestarbuck.ui.theme.BlackAlpha65
import com.fajarazay.github.composestarbuck.ui.theme.ColorPrimary

@Composable
fun InputField(hintText: String, inputType: String = "", modifier: Modifier = Modifier) {
    var value by remember {mutableStateOf("")}
    val passwordVisibility by remember {mutableStateOf(true)}

    Column(modifier = modifier) {
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.padding(bottom = 2.dp)
        ) {
            if (value.isEmpty()) {
                Text(
                    text = hintText,
                    style = TextStyle(
                        color = BlackAlpha65,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            BasicTextField(
                value = value,
                cursorBrush = SolidColor(ColorPrimary),
                textStyle = TextStyle(
                    color = BlackAlpha65,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                ),
                visualTransformation = if (passwordVisibility && inputType != "password") VisualTransformation.None else PasswordVisualTransformation(),
                onValueChange = {
                    value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp),
            )

            if (inputType == "password") {
                Image(
                    painter = painterResource(id = com.fajarazay.github.composestarbuck.R.drawable.ic_eye_slash),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(bottom = 4.dp)
                        .padding(horizontal = 2.dp)
                )
            }
        }
        Divider(color = BlackAlpha65, thickness = 1.dp)

    }
}

@Preview
@Composable
fun InputFieldPreview() {
    InputField(hintText = "password", inputType = "password")
}
