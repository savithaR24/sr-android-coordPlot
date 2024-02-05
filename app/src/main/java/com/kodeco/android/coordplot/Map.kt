package com.kodeco.android.coordplot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val MAX_WIDTH = 200
private const val CIRCLE_DIAMETER = 28
private const val CIRCLE_RADIUS = CIRCLE_DIAMETER / 2

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    Box(
        modifier
            .background(MaterialTheme.colorScheme.tertiary)
            .size(MAX_WIDTH.dp)
    ) {
        val image = painterResource(R.drawable.spaceshuttle)
        Box(
            modifier
                .offset(
                    (xPercent * MAX_WIDTH - CIRCLE_RADIUS).dp,
                    (yPercent * MAX_WIDTH - CIRCLE_RADIUS).dp
                )
                .size(CIRCLE_DIAMETER.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    Map(xPercent = 0.5f, yPercent = 0.5f)
}