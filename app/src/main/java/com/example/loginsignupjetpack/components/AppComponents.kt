package com.example.loginsignupjetpack.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginsignupjetpack.R
import com.example.loginsignupjetpack.ui.theme.GrayColor
import com.example.loginsignupjetpack.ui.theme.Primary
import com.example.loginsignupjetpack.ui.theme.TextColor
import com.example.loginsignupjetpack.ui.theme.bgColor

@Composable
fun NormalTextComposable(value: String){
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComposable(value: String){
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String, painterResource: Painter){

    val textValue = remember {
        mutableStateOf("")
    }


    Column() {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(bgColor),
            label = { Text(text = labelValue) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary,
                focusedLabelColor = Primary,
                cursorColor = Primary
            ),

            keyboardOptions = KeyboardOptions.Default,
            value = textValue.value,
            onValueChange = {
                textValue.value = it
            },
            leadingIcon = { Icon(painter = painterResource, contentDescription = "")}
        )

        Spacer(modifier = Modifier.height(10.dp))


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue: String, painterResource: Painter){

    val passwdValue = remember {
        mutableStateOf("")
    }

    val passwdVisible = remember {
        mutableStateOf(false)
    }


    Column() {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(bgColor),
            label = { Text(text = labelValue) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary,
                focusedLabelColor = Primary,
                cursorColor = Primary
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = passwdValue.value,
            onValueChange = {
                passwdValue.value = it
            },

            leadingIcon = {
                Icon(painter = painterResource, contentDescription = "" )
            },

            trailingIcon = {
                val iconImage = if(passwdVisible.value){
                    Icons.Filled.Visibility
                }else{
                    Icons.Filled.VisibilityOff
                }

                var description = if (passwdVisible.value){
                    stringResource(id = R.string.hide_password)
                }else{
                    stringResource(id = R.string.strong_password)
                }

                IconButton(onClick = {passwdVisible.value = !passwdVisible.value}) {
                    Icon(imageVector = iconImage, contentDescription = description)
                }
            },

            visualTransformation = if(passwdVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(10.dp))

    }

}

@Composable
fun ClickableTextComponent(onTextSelected : (String) -> Unit){
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy "
    val andText = "and "
    val termsOfUseText = "Terms of use"

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = GrayColor)){
            append(initialText)
        }
        withStyle(style = SpanStyle(color = GrayColor, textDecoration = TextDecoration.Underline)){
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }

        withStyle(style = SpanStyle(color = GrayColor)){
            append(andText)
        }

        withStyle(style = SpanStyle(color = GrayColor, textDecoration = TextDecoration.Underline)){
            pushStringAnnotation(tag = termsOfUseText, annotation = termsOfUseText)
            append(termsOfUseText)
        }
    }

    ClickableText(text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
            Log.d("ClickableTextComponent", "{$span}")

            if(span.item == termsOfUseText){
                onTextSelected(span.item)
            }
        }
    })

}

@Composable
fun CheckboxComponent(onTextSelected : (String) -> Unit){
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){

        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = !checkedState.value
        })

        ClickableTextComponent(onTextSelected)
    }
}

@Composable
fun ButtonComponent(value: String){
    Button(onClick = {},
        ){

    }
}

