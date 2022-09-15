package com.fi.githubfinder.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fi.githubfinder.R
import kotlinx.coroutines.delay

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

28/07/2022, 12:05 pm
 ****************************************
 */

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember{
        mutableStateOf(false)
    }

    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Home.name)
    }
    
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float){
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.primaryVariant)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
            tint = Color.White.copy(
                alpha = alpha
            ),
        )
    }
}