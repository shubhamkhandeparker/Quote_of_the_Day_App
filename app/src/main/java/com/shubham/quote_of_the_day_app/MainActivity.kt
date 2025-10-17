package com.shubham.quote_of_the_day_app

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubham.quote_of_the_day_app.ui.theme.Quote_of_the_Day_AppTheme

class MainActivity : ComponentActivity() {
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
fun QuoteScreen() {

    //1.Our data : A map of categories to pair of (Quote,Author)

    val quotes = mapOf(
        "Inspiration" to Pair(
            "\"The gratest glory in living lies not in falling but in rising every time we fall .\"",
            "_Nelson Mandela "
        ),
        "Humor" to Pair(
            "\" I'm sick of following my dreams man. I'm just going to ask where they're going and hook up wih them later.\"",
            "-Mitch Hedberg"
        ),
        "Technology" to Pair(
            "\"The advance of technology is based on making it fit in so that you don't even notice it , so it's part of everyday life.\"",
            "-Bill Gates"
        )
    )


    //2.Sate Variable for the selected category and dropdown expansion
    var selectedCategory by remember { mutableStateOf("Inspiration") }
    var isExpanded by remember { mutableStateOf(false) }

    //3.Get the current quote & author based on the selected category
    //The '!!' asserts that the key will never be null , which is safe here
    val (quote, author) = quotes[selectedCategory]!!

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //4.The Dropdown menu UI

        Box {
            Button(onClick = { isExpanded = true }) {
                Text("$selectedCategory ▼")
            }
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                quotes.keys.forEach { category ->
                    DropdownMenuItem(
                        text = { Text(category) },
                        onClick = {
                            selectedCategory = category
                            isExpanded = false
                        }
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        //5.The card Now display the dynamic quote and author
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp))
            {

                Text(
                    text = quote, //Use the dynamic quote variable
                    style = MaterialTheme.typography.headlineSmall,
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = author,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(Alignment.End)
                )

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun QuotePreview() {
    Quote_of_the_Day_AppTheme {
        QuoteScreen()
    }
}