package com.fi.githubfinder.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fi.githubfinder.R

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

28/07/2022, 12:05 pm
 ****************************************
 */

@Preview
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    viewModel.getGit()

    Scaffold(
        topBar = {
            TopAppBar {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    ) {
        Column {
            if(viewModel.isLoading.value) CircularProgressIndicator()
        }
    }
}