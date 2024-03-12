package com.example.loginsignupjetpack.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginsignupjetpack.R
import com.example.loginsignupjetpack.components.*
import com.example.loginsignupjetpack.navigation.AppRouter
import com.example.loginsignupjetpack.navigation.Screen

@Composable
fun SignupScreen() {
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp))
    {
        Column(modifier = Modifier.fillMaxSize()){
            NormalTextComposable(value = stringResource(id = R.string.hello))
            HeadingTextComposable(value = stringResource(id = R.string.create_an_account))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextField(
                labelValue = stringResource(id = R.string.first_name),
                painterResource(R.drawable.ic_lock))

            MyTextField(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = painterResource(R.drawable.ic_lock)
            )

            MyTextField(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(R.drawable.ic_lock)
            )

            MyTextField(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(R.drawable.ic_lock)
            )

            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                painterResource(R.drawable.ic_lock))

            CheckboxComponent(onTextSelected =
                {
                    AppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                }
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewSignupScreen(){
    SignupScreen()
}