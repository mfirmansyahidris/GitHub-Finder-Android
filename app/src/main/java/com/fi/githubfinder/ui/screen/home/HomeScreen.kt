package com.fi.githubfinder.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.fi.githubfinder.R

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

28/07/2022, 12:05 pm
 ****************************************
 */

@Composable
fun HomeScreen(){
    LazyColumn {
        items(20){
            GitRepoItem()
            Divider()
        }
    }
}

@Composable
fun GitRepoItem(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 10.dp
            )
    ) {
        Row {
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = rememberAsyncImagePainter("https://avatars.githubusercontent.com/u/31582273?v=4"),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1F)) {
                Text(
                    text = "User Name",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sagittis ex id arcu fringilla eleifend. Nam ultricies arcu quam, a blandit urna condimentum consequat. Maecenas erat odio, fermentum at tincidunt eu, lobortis eu turpis. Vivamus non dolor vehicula, ornare nisi in, congue dolor. Curabitur sagittis est condimentum consequat finibus. Integer quis elit quis ligula viverra ultricies vestibulum eget ipsum. Sed ac elementum ligula. Praesent lacus erat, pretium vel mi a, euismod dignissim ante. Morbi a luctus quam. Aenean a pretium quam. Praesent sem massa, luctus sit amet rhoncus eget, interdum sit amet velit. Donec convallis eget odio ac mollis",
                    style = TextStyle(
                        fontSize = 14.sp,
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Java",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.Gray
                    ),
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(
                onClick = {}
            ){
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    }
}

@Composable
fun HomeScreenDev(
    viewModel: HomeViewModel = hiltViewModel(),
) {
//    val uiState by viewModel.uiState.collectAsState(HomeUIState(isLoading = false))
    val time by viewModel.countDown.collectAsState(initial = 10)

    Column {
        //if(uiState.isLoading) CircularProgressIndicator()
    }
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = time.toString(),
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}