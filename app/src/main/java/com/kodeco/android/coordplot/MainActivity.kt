package com.kodeco.android.coordplot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                PlotSurface()
            }
        }
    }
}

@Composable
fun PlotSurface() {
    var sliderXPosition by rememberSaveable { mutableFloatStateOf(0.0f) }
    var sliderYPosition by rememberSaveable { mutableFloatStateOf(0.0f) }
    var xValue = sliderXPosition * 100
    var yValue = sliderYPosition * 100

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.app_name),
                modifier = Modifier.padding(40.dp)
            )
            Map(xPercent = sliderXPosition, yPercent = sliderYPosition)

            Text(
                text = stringResource(R.string.x_axis, xValue.toInt()),
                modifier = Modifier.padding(10.dp)
            )
            SliderX(
                value = sliderXPosition,
                valueChanged = { value ->
                    sliderXPosition = value
                }
            )
            Text(
                text = stringResource(R.string.y_axis, yValue.toInt()),
                modifier = Modifier.padding(10.dp)
            )
            SliderY(
                value = sliderYPosition,
                valueChanged = { value ->
                    sliderYPosition = value
                }
            )
        }
    }
}

@Composable
fun SliderX(value: Float = 0.0f, valueChanged: (Float) -> Unit) {
    Slider(
        value = value,
        onValueChange = valueChanged,
//        thumb = {
//            Image(
//                painter = painterResource(id = R.drawable.spaceshuttle),
//                contentDescription = null
//            )
//        }
    )
}

@Composable
fun SliderY(value: Float = 0.0f, valueChanged: (Float) -> Unit) {
    Slider(
        value = value,
        onValueChange = valueChanged
    )
}

private const val MAX_WIDTH = 300
private const val CIRCLE_DIAMETER = 28
private const val CIRCLE_RADIUS = CIRCLE_DIAMETER / 2

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    Box(
        modifier
            .background(Color.Cyan)
            .size(300.dp)
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
fun PlotSurfacePreview() {
    MyApplicationTheme {
        PlotSurface()
    }
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}
