package com.example.demow7

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.demow7.ui.theme.Demow7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Demow7Theme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { //innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    CheckNetworkStatus()
                //}
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Composable
//fun CheckNetworkStatus() {
//    // Get the current context
//    val context = LocalContext.current
//    // Remember the current network status
//    val isNetworkAvailable by remember {
//        mutableStateOf(isInternetAvailable(context))
//    }
//
//    // Display the network status
//    if (isNetworkAvailable) {
//        Text(text = "Network is available")
//    } else {
//        Text(text = "Network is not available")
//    }
//}

@Composable
fun CheckNetworkStatus() {
    val context = LocalContext.current
    var networkType by remember { mutableStateOf("Đang kiểm tra kết nối...") }
    var isNetworkAvailable by remember { mutableStateOf(true) }
    val networkChangeReceiver = remember {
        NetworkChangeReceiver { isAvailable ->
            isNetworkAvailable = isAvailable
        }
    }
    LaunchedEffect(Unit) {
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        context.registerReceiver(networkChangeReceiver, filter)
        networkType = checkNetworkType(context)
    }
    DisposableEffect(Unit) {
        onDispose {
            context.unregisterReceiver(networkChangeReceiver)
        }
    }
    if (isNetworkAvailable) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Network is available")
            Text(text = networkType)
        }
    } else {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Network is not available")
        }
    }
}
class NetworkChangeReceiver(private val onNetworkChange: (Boolean) -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        onNetworkChange(activeNetwork?.isConnected == true)
    }
}


//private fun isInternetAvailable(context: Context): Boolean {
//    var result = false
//    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//        val networkCapabilities = connectivityManager.activeNetwork ?: return false
//        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
//        result = when {
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//            else -> false
//        }
//    } else {
//        connectivityManager.run {
//            connectivityManager.activeNetworkInfo?.run {
//                result = when (type) {
//                    ConnectivityManager.TYPE_WIFI -> true
//                    ConnectivityManager.TYPE_MOBILE -> true
//                    ConnectivityManager.TYPE_ETHERNET -> true
//                    else -> false
//                }
//            }
//        }
//    }
//    return result
//}

//fun CheckNetworkAvailability(context: Context): Boolean {
//    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    val activeNetwork = connectivityManager.activeNetwork ?: return false
//    val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
//    return when {
//        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//        else -> false
//    }
//}

/** check loai ket noi */
// return string loai ket noi
fun checkNetworkType(context: Context): String {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetwork ?: return "Không có kết nối"
    val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return "Không có kết nối"

    return when {
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "Kết nối qua Wi-Fi"
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "Kết nối qua Di động"
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> "Kết nối qua Ethernet"
        else -> "Kết nối không xác định"
    }
}

@Composable
fun NetworkTypeStatus() {
    val context = LocalContext.current
    var networkType by remember { mutableStateOf("Đang kiểm tra kết nối...") }

    // Check network type when the composable is displayed
    LaunchedEffect(Unit) {
        networkType = checkNetworkType(context)
    }

    // Display the network type
    Text(text = networkType)
}

/** test build uri */
@Composable
fun BuildUriExample() {
    val builder = Uri.Builder()
        .scheme("https")
        .authority("www.myawesomesite.com")
        .appendPath("turtles")
        .appendPath("types")
        .appendQueryParameter("type", "1")
        .appendQueryParameter("sort", "relevance")
        .fragment("section-name")

    val myUrl = builder.build().toString()

    Text(text = "URL: $myUrl")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Demow7Theme {
        Greeting("Android")
    }
}