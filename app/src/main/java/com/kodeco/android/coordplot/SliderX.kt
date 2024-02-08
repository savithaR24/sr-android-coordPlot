package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SliderX(value: Float = 0.0f, valueChanged: (Float) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.x_axis, (value * 100).toInt()),
            modifier = Modifier.padding(10.dp)
        )
        Slider(
            modifier = Modifier.padding(10.dp),
            value = value,
            onValueChange = valueChanged
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SliderXPreview() {
    SliderX(valueChanged = {})
}