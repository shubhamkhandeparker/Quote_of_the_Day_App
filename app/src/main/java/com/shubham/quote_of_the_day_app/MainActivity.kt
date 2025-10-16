package com.shubham.quote_of_the_day_app

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubham.quote_of_the_day_app.ui.theme.Quote_of_the_Day_AppTheme

class MainActivity : ComponentActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Quote_of_the_Day_AppTheme {
                QuoteScreen()
            }
        }
    }
}

@Composable
fun QuoteScreen (){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card(modifier=Modifier.padding(16.dp)
            .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ){
            Column(modifier =Modifier.padding(16.dp)){

                Text(
                    text="\" The gratest glory in living lies not in never falling , but in rising every time we fall .\"",
                    style = MaterialTheme.typography.headlineSmall,
                    fontStyle = FontStyle.Italic)

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text ="-Nelson Mandela",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }



    }

}

@Preview(showBackground = true)
@Composable
fun QuotePreview (){
    Quote_of_the_Day_AppTheme {
        QuoteScreen()
    }
}