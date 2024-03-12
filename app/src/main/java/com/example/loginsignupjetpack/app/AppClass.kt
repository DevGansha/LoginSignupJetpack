package com.example.loginsignupjetpack.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.loginsignupjetpack.navigation.AppRouter
import com.example.loginsignupjetpack.navigation.Screen
import com.example.loginsignupjetpack.ui.theme.WhiteColor

@Composable
fun AppClass (){
    Surface (modifier =  Modifier.fillMaxSize(), color = WhiteColor) {
        Crossfade(targetState = AppRouter.currentScreen, label = "") { currentScreen ->
            when (currentScreen.value) {
                is Screen.SignupScreen -> Screen.SignupScreen
                is Screen.TermsAndConditionsScreen -> Screen.TermsAndConditionsScreen
            }
        }
    }
}