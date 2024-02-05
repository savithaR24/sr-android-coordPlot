package com.kodeco.android.coordplot

import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme


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

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(R.string.app_name),
                modifier = Modifier.padding(10.dp)
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


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PlotSurfacePreview() {
    MyApplicationTheme {
        PlotSurface()
    }
}

//@Preview(showBackground = true, name = "5-inch Device Portrait", widthDp = 360, heightDp = 640)
//@Composable
//fun PlotSurfacePreview() {
//    MyApplicationTheme {
//        PlotSurface()
//    }
//}

//@Preview(showBackground = true, name = "5-inch Device Landscape", widthDp = 640, heightDp = 360)
//@Composable
//fun PlotSurfacePreview() {
//    MyApplicationTheme {
//        PlotSurface()
//    }
//}

//@Preview(showBackground = true, name = "10-inch Tablet Portrait", widthDp = 600, heightDp = 960)
//@Composable
//fun PlotSurfacePreview() {
//    MyApplicationTheme {
//        PlotSurface()
//    }
//}

//@Preview(showBackground = true, name = "10-inch Tablet Landscape", widthDp = 960, heightDp = 600)
//@Composable
//fun PlotSurfacePreview() {
//    MyApplicationTheme {
//        PlotSurface()
//    }
//}
