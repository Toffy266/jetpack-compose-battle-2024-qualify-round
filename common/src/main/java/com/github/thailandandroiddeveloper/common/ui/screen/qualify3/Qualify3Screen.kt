package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify3Screen() {
    // TODO: Qualify3
    Scaffold(
        containerColor = MaterialTheme.colorScheme.onPrimary,
        topBar = {
            TopAppBar3Component()
        },
    ) { innerPadding ->
        ProfileContent(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        bottom = 18.dp,
                    ),
        )
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() =
    AppTheme {
        Qualify3Screen()
    }
// endregion

@Composable
fun ProfileContent(modifier: Modifier = Modifier) {
    val imageList =
        listOf(
            painterResource(
                id = R.drawable.img_qualify_3_photo_1,
            ),
            painterResource(
                id = R.drawable.img_qualify_3_photo_2,
            ),
            painterResource(
                id = R.drawable.img_qualify_3_photo_3,
            ),
        )

    val tagList =
        listOf(
            "Tag 1",
            "Tag 2",
            "Tag 3",
            "Tag 4",
        )
    val itemCount = 4

    LazyColumn(
        modifier = modifier,
    ) {
        item {
            ImageGalleryComponent(
                imageList = imageList,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(320.dp),
            )
        }
        item {
            TagComponent(
                tagList = tagList,
                modifier = Modifier.padding(top = 16.dp),
            )
        }
        items(itemCount) {
            CardComponent(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 16.dp,
                            end = 16.dp,
                        )
                        .height(96.dp),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar3Component() {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector =
                        ImageVector.vectorResource(
                            R.drawable.ic_qualify_3_back,
                        ),
                    contentDescription = "Back Icon",
                )
            }
        },
        title = {
            Text(
                text = "John Doe",
                style = MaterialTheme.typography.titleLarge,
            )
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector =
                        ImageVector.vectorResource(
                            R.drawable.ic_qualify_3_copy,
                        ),
                    contentDescription = "Copy Icon",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector =
                        ImageVector.vectorResource(
                            R.drawable.ic_qualify_3_calendar,
                        ),
                    contentDescription = "Calendar Icon",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector =
                        ImageVector.vectorResource(
                            R.drawable.ic_qualify_3_menu,
                        ),
                    contentDescription = "Menu Icon",
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageGalleryComponent(
    imageList: List<Painter>,
    modifier: Modifier = Modifier,
) {
    var selected by remember { mutableStateOf(List(imageList.size) { false }) }
    selected =
        selected.toMutableList().apply {
            set(0, true)
        }

    LazyRow(
        modifier = modifier,
    ) {
        items(imageList) { image ->
            val index = imageList.indexOf(image)

            Card(
                modifier =
                    Modifier
                        .padding(end = 16.dp)
                        .width(160.dp)
                        .combinedClickable(
                            onClick = {
                                selected =
                                    selected.toMutableList().apply {
                                        set(index, !this[index])
                                    }
                            },
                        ),
                border =
                    BorderStroke(
                        width = 1.dp,
                        color =
                            if (selected[index]) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.primaryContainer
                            },
                    ),
                shape = RoundedCornerShape(16.dp),
            ) {
                Image(
                    painter = imageList[index],
                    contentDescription = "Photo",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TagComponent(
    tagList: List<String>,
    modifier: Modifier = Modifier,
) {
    var selected by remember { mutableStateOf(List(tagList.size) { false }) }
    selected =
        selected.toMutableList().apply {
            set(0, true)
        }

    LazyRow(
        modifier = modifier,
    ) {
        items(tagList) { tag ->
            val index = tagList.indexOf(tag)

            OutlinedCard(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                        .size(68.dp, 32.dp)
                        .combinedClickable(
                            onClick = {
                                selected =
                                    selected.toMutableList().apply {
                                        set(index, !this[index])
                                    }
                            },
                        ),
                colors =
                    CardDefaults.cardColors(
                        MaterialTheme.colorScheme.onPrimary,
                    ),
                border =
                    BorderStroke(
                        width = 1.dp,
                        color =
                            if (selected[index]) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.outline
                            },
                    ),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = tagList[index],
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 6.dp,
                                bottom = 6.dp,
                            ),
                    style = MaterialTheme.typography.labelLarge,
                    color =
                        if (selected[index]) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.outline
                        },
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun CardComponent(modifier: Modifier) {
    Card(
        modifier = modifier,
        colors =
            CardDefaults.cardColors(
                MaterialTheme.colorScheme.surface,
            ),
        border =
            BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.surfaceVariant,
            ),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxHeight()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                    ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Column(
                modifier =
                    Modifier
                        .fillMaxHeight()
                        .padding(
                            top = 16.dp,
                            bottom = 32.dp,
                        )
                        .size(48.dp)
                        .clip(CircleShape),
            ) {
                Image(
                    painter =
                        painterResource(
                            id = R.drawable.img_qualify_3_sender,
                        ),
                    contentDescription = "Sender Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }
            Column(
                modifier =
                    Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterVertically)
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp,
                        ),
            ) {
                Text(
                    text = "Lorem Ipsum",
                    modifier = Modifier.height(24.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = "JDuis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
                    modifier = Modifier.height(40.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}
