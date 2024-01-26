package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Qualify1Screen() {
    // TODO: Qualify1
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBarComponent()
        },
    ) { innerPadding ->
        LazyColumn(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
        ) {
            item {
                MainContent(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .wrapContentSize()
                            .padding(
                                top = 16.dp,
                                start = 16.dp,
                                end = 16.dp,
                                bottom = 72.dp,
                            ),
                )
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() =
    AppTheme {
        Qualify1Screen()
    }
// endregion

// MainContent
@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
    ) {
        ProfileCardComponent(
            modifier =
                Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(16.dp),
                    ),
        )
        Row(
            modifier =
                Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(43.dp),
        ) {
            ButtonThumbDownComponent(
                modifier =
                    Modifier
                        .size(120.dp, 48.dp),
            )
            ButtonThumbUpComponent(
                modifier =
                    Modifier
                        .size(120.dp, 48.dp),
            )
        }
    }
}

// Top app bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent() {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector =
                        ImageVector.vectorResource(
                            R.drawable.ic_qualify_1_menu,
                        ),
                    contentDescription = "Menu Icon",
                )
            }
        },
        title = { /* do something */ },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector =
                        ImageVector.vectorResource(
                            R.drawable.ic_qualify_1_profile,
                        ),
                    contentDescription = "Profile Icon",
                )
            }
        },
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            ),
    )
}

@Composable
fun ProfileCardComponent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
    ) {
        Image(
            painter =
                painterResource(
                    id = R.drawable.img_qualify_1_profile,
                ),
            contentDescription = null,
        )
        ProfileDescriptionComponent(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(192.dp)
                    .align(
                        Alignment.BottomCenter,
                    )
                    .background(
                        MaterialTheme.colorScheme.primary.copy(
                            alpha = 0.75f,
                        ),
                    )
                    .padding(20.dp),
        )
    }
}

@Composable
fun ProfileDescriptionComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimary,
        )
        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector =
                    ImageVector.vectorResource(
                        R.drawable.ic_qualify_1_gender_male,
                    ),
                contentDescription = "Gender Male Icon",
                tint = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = "Male",
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
        Text(
            text = "Lorem ipsum dolor sit amet, cd nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla.",
            modifier = Modifier.padding(top = 10.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Composable
fun ButtonThumbDownComponent(modifier: Modifier = Modifier) {
    IconButton(
        onClick = { /*TODO*/ },
        modifier = modifier,
        colors =
            IconButtonDefaults.iconButtonColors(
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer,
            ),
    ) {
        Icon(
            imageVector =
                ImageVector.vectorResource(
                    R.drawable.ic_qualify_1_thumb_down,
                ),
            contentDescription = "Thumb Down Icon",
        )
    }
}

@Composable
fun ButtonThumbUpComponent(modifier: Modifier = Modifier) {
    IconButton(
        onClick = { /*TODO*/ },
        modifier = modifier,
        colors =
            IconButtonDefaults.iconButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            ),
    ) {
        Icon(
            imageVector =
                ImageVector.vectorResource(
                    R.drawable.ic_qualify_1_thumb_up,
                ),
            contentDescription = "Thumb Up Icon",
        )
    }
}
