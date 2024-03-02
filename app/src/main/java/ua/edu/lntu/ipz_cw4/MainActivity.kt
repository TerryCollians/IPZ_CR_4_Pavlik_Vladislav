package ua.edu.lntu.ipz_cw4

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                    App()
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
        // Список елементів LazyColumn
        LazyColumn{
            itemsIndexed(items) {index, item ->
                ListItem(index  , item  , onItemClick  )
            }
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

@Composable

// Функція для відображення другого екрану
fun Screen2(selectedItem: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Вивід тексту "Screen2"
        Text("Екран 2")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Вибрано елементів: $selectedItem")
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

// функція програми яка об'єднує всі елементи і забезпечує їх взаємодію.
fun App() {
    // Збереження стану
    var selectedItem by remember { mutableIntStateOf(-1) }
    var currentScreen by remember { mutableIntStateOf(0) }

    // Створення списку елементів
    val items = remember { List(10) {"Елемент $it"} }

    // Відображення додатку
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Віталій Володимирович, виберіть кількість елементів") },
                navigationIcon = {
                    IconButton(onClick = { currentScreen = 0 }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        // оператор when щоб визначити який екран треба відобразити
        when (currentScreen) {
            0 -> Screen1(items = items ) {
                index -> selectedItem = index
                currentScreen = 1
            }
            1 -> Screen2(selectedItem = selectedItem)
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IPZ_CR_4Theme {
        App()
    }
}