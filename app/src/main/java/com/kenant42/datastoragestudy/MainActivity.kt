package com.kenant42.datastoragestudy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenant42.datastoragestudy.ui.theme.DataStorageStudyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataStorageStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    val context = LocalContext.current
    val datastoreRef = ApplicationDatastore(context)




    LaunchedEffect(key1 = true) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            datastoreRef.saveName("Kenan")
            datastoreRef.saveSurname("Taşdemir")
            datastoreRef.saveAge(24)
            datastoreRef.saveHeight(1.70)
            datastoreRef.saveWeight(70)
            datastoreRef.saveMarriageStatus(false)

            val friendsList = HashSet<String>()
            friendsList.add("Ahmet")
            friendsList.add("Ali")
            friendsList.add("Hasan")
            friendsList.add("Mehmet")
            datastoreRef.saveFriendsList(friendsList)


            val name = datastoreRef.getName()
            val surname = datastoreRef.getSurname()
            val age = datastoreRef.getAge()
            val weight = datastoreRef.getWeight()
            val height = datastoreRef.getHeight()
            val isMarried = datastoreRef.getMarriageStatus()
            val buddyList = datastoreRef.getFriendsList()


            Log.w("Name: ", "$name")
            Log.w("Surname: ", "$surname")
            Log.w("Age: ", "$age")
            Log.w("Weight: ", "$weight")
            Log.w("Height: ", "$height")
            Log.w("is Married: ", "$isMarried")


            for (friend in buddyList!!) {
                Log.w("Friend Name", "$friend")
            }
        }


    }


    Column(modifier = Modifier.padding(top = 70.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(
            text = "Lütfen Logcat açın, Warning kısmında veriler görüntülenecektir.",
            fontFamily = FontFamily.Monospace,
            fontSize = 35.sp,
            modifier = Modifier.width(350.dp),
            lineHeight = 65.sp,
            textAlign = TextAlign.Center
        )
    }

}


