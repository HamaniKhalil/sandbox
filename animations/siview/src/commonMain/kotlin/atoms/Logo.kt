package atoms

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import themes.darkGray
import themes.lightGray
import themes.lightLightColor
import themes.primaryColor
import themes.secondaryColor
import themes.ternaryColor

@Composable
fun Logo() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {

        val startAngle = 245f
        val arcs = listOf(
            primaryColor,
            secondaryColor,
            ternaryColor,
            lightGray,
            darkGray,
        )

        val scale = 1f
        val size = 300 * scale
        val innerSize = size * 0.7f
        val irisSize = innerSize * 0.6f
        val pupilSize = irisSize * 0.3f
        val stroke = 35f * scale
        val sweepAngler = 60f

        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(size.dp),
        ) {
            var currentStartAngle = startAngle
            arcs.forEach { color ->
                drawArc(
                    color = color,
                    startAngle = currentStartAngle,
                    sweepAngle = sweepAngler,
                    useCenter = true,
                    style = Stroke(width = stroke),
                )
                currentStartAngle += sweepAngler
            }

            drawArc(
                color = Color.White,
                startAngle = currentStartAngle + 3f,
                sweepAngle = 54f,
                useCenter = true,
                style = Stroke(width = stroke),
            )
        }

        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(size.dp),
        ) {
            drawCircle(
                color = Color.White,
                style = Fill,
            )
        }

        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(size.dp),
        ) {
            drawArc(
                color = lightLightColor,
                startAngle = startAngle,
                sweepAngle = arcs.size * sweepAngler,
                useCenter = true,
            )
        }

        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(innerSize.dp),
        ) {
            drawCircle(
                color = Color.White,
                style = Fill,
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Canvas(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(irisSize.dp),
            ) {
                drawCircle(
                    color = Color.Black,
                    style = Fill,
                )
            }

            Canvas(
                modifier = Modifier
                    .size(pupilSize.dp)
                    .offset(
                        x = (-irisSize / 25).dp,
                        y = (irisSize / 15).dp,
                    ),
            ) {
                drawCircle(
                    color = Color.White,
                    style = Fill,
                )
            }
        }
    }


}


@Preview
@Composable
fun LogoPreview() {
    Logo()
}


