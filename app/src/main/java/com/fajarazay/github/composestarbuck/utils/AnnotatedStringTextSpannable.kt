package com.fajarazay.github.composestarbuck.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.fajarazay.github.composestarbuck.ui.theme.ColorPrimary
import com.fajarazay.github.composestarbuck.ui.theme.GreyAlpha72

object AnnotatedStringTextSpannable {
    fun setAnnotatedString(
        firstAppend: String,
        tagAnnotation: String,
        secondAppend: String
    ): AnnotatedString {
        return buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = GreyAlpha72,
                )
            ) {
                append(firstAppend)

            }
            pushStringAnnotation(
                tag = tagAnnotation, // provide tag which will then be provided when you click the text
                annotation = tagAnnotation
            )
            //add text with your different color/style
            withStyle(
                style = SpanStyle(
                    color = ColorPrimary,
                )
            ) {
                append(secondAppend)
            }
            // when pop is called it means the end of annotation with current tag
            pop()
        }
    }
}
