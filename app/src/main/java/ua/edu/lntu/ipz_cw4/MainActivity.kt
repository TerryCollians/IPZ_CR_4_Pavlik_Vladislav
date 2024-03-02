package ua.edu.lntu.ipz_cw4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.ipz_cw4.ui.theme.IPZ_CR_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CR_4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable

// Функція першого екрану
fun Screen1(items: List<String>, onItemClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Text("Screen 1")
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn{

        }

    }
}



@Composable
// Функція для представлення кожного елементу списку
fun ListItem(index: Int, item: String, onItemClick: (Int) -> Unit) {
   Row(
       modifier = Modifier
           .fillMaxWidth()
           .clickable { onItemClick(index) }
           .padding(8.dp),
       verticalAlignment = Alignment.CenterVertically
   )
   {
       // Текстове поле для відображення тексту елементу
       Text(text = item)
   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IPZ_CR_4Theme {

    }
}