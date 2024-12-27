package com.ridvanozcan.chatbotaibootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ridvanozcan.chatbotaibootcamp.ui.theme.ChatBotAIBootcampTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatBotAIBootcampTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: ChatGptViewModel = hiltViewModel() ) {

    val generatedMessage = viewModel.generateMessage.value

    Column {

        generatedMessage?.takeIf { it.isNotEmpty() }?.let{

            Text(

                text = it.first().message.content,
                modifier = modifier
            )

        }


        Button (onClick = {viewModel.createMessage("Türkiyenin başkenti neresidir?")}){
            Text(text = "Mesaj Gönder")

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatBotAIBootcampTheme {
        Greeting("Android")
    }
}