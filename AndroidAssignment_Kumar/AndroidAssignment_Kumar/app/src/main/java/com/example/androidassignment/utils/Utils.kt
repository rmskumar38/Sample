@file:Suppress("DEPRECATION")

package com.example.androidassignment.utils

import android.content.Context
import android.net.ConnectivityManager

object Utils {

    fun checkNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}