package com.kodeco.android.coordplot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.setValue

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
    var sliderXPosition by remember { mutableFloatStateOf(0.0f) }
    var sliderYPosition by remember { mutableFloatStateOf(0.0f) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        // TODO Build out the plot surface
        //  This should include a Column composable that
        //  includes a Map, and two MapSlider composable
        //  (one slider for each axis).

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "COORDINATE PLOTTER",
                modifier = Modifier.padding(40.dp)
            )
            Map(xPercent = sliderXPosition, yPercent = sliderYPosition)
            SliderX(
                value = sliderXPosition,
                valueChanged = { value ->
                    sliderXPosition = value
                }
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
        onValueChange = valueChanged
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
private const val CIRCLE_DIAMETER = 12
private const val CIRCLE_RADIUS = CIRCLE_DIAMETER / 2

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    // TODO fill out the square map here.
    //  Create a Box composable with a size of 300.dp
    //  and then create an inner Box composable
    //  with a clip shape of CircleShape.

    Box(
        modifier
            .background(Color.Blue)
            .size(300.dp)
    ) {
        Box(
            modifier
                .offset(
                    (xPercent * MAX_WIDTH - CIRCLE_RADIUS).dp,
                    (yPercent * MAX_WIDTH - CIRCLE_RADIUS).dp
                )
                .clip(shape = CircleShape)
                .background(Color.Green)
                .size(CIRCLE_DIAMETER.dp)
        )
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
