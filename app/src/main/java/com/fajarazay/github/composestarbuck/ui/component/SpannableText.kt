package com.fajarazay.github.composestarbuck.ui.component

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SpannableText(
    annotatedText: AnnotatedString,
    onClick: (() -> Unit)? = null,
    tag: String,
) {
    ClickableText(
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        ),
        text = annotatedText,
        onClick = {offset ->
            annotatedText.getStringAnnotations(
                tag = tag, // tag which you used in the buildAnnotatedString
                start = offset,
                end = offset
            ).firstOrNull()?.let {_ ->
                onClick?.invoke()
            }
        }
    )
}
