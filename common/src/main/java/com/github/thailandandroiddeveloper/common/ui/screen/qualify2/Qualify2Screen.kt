package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify2Screen() {
    // TODO: Qualify2
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBarComponent(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 8.dp,
                            end = 8.dp,
                        ),
            )
        },
        bottomBar = {
            BottomAppBarComponent(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(102.dp)
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                        ),
            )
        },
    ) { innerPadding ->
        TutorialContent(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(
                        top = 16.dp,
                        start = 32.dp,
                        end = 32.dp,
                        bottom = 48.dp,
                    ),
        )
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() =
    AppTheme {
        Qualify2Screen()
    }
// endregion

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TutorialContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        TextComponent(
            modifier = Modifier.fillMaxWidth(),
        )
        PagerComponent(
            pagerState =
                rememberPagerState(
                    initialPage = 3,
                    pageCount = { 5 },
                ),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
        )
    }
}

@Composable
fun TopAppBarComponent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterEnd,
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(59.dp, 40.dp),
        ) {
            Text(
                text = "Skip",
                style =
                    MaterialTheme.typography.labelLarge.copy(
                        platformStyle =
                            PlatformTextStyle(
                                includeFontPadding = false,
                            ),
                    ),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun TextComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "Lorem ipsum dolor sit amet",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )
        Text(
            text =
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu" +
                    "\nneque, porttitor ac metus quis, iaculis molestie " +
                    "\nmagna. Vivamus molestie justo sed nulla lacinia, " +
                    "\nquis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla",
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerComponent(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            state = pagerState,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .size(347.dp, 446.dp)
                    .clip(
                        RoundedCornerShape(16.dp),
                    ),
        ) { page ->
            Image(
                painter =
                    painterResource(
                        id = R.drawable.img_qualify_2_onboard,
                    ),
                contentDescription = "Onboard Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }
        PageIndicatorComponent(
            pagerState = pagerState,
            modifier = Modifier.padding(top = 32.dp),
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageIndicatorComponent(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        repeat(pagerState.pageCount) { iteration ->
            Box(
                modifier =
                    Modifier
                        .background(
                            color =
                                if (pagerState.currentPage == iteration) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.primaryContainer
                                },
                            shape = CircleShape,
                        )
                        .size(
                            width =
                                if (pagerState.currentPage == iteration) {
                                    32.dp
                                } else {
                                    16.dp
                                },
                            height = 16.dp,
                        ),
            )
        }
    }
}

@Composable
fun BottomAppBarComponent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier =
                Modifier
                    .size(251.dp, 40.dp),
        ) {
            Text(
                text = "Next",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}
