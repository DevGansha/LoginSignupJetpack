package com.example.loginsignupjetpack.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginsignupjetpack.R
import com.example.loginsignupjetpack.components.HeadingTextComposable
import com.example.loginsignupjetpack.ui.theme.WhiteColor

@Composable
fun TermsAndConditionsScreen () {

    Surface (modifier = Modifier
        .fillMaxSize()
        .background(WhiteColor)
        .padding(16.dp)) {
        
        HeadingTextComposable(value = stringResource(id = R.string.tnc_heading))

    }
}

@Preview
@Composable
fun TermsAndConditionsPreview(){
    TermsAndConditionsScreen()
}