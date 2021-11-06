package com.example.retrofitcourse.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {

    fun <T: Any> ioThenMain(work: suspend (() -> T?), callback: (T?) -> Unit) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async {
                return@async work
            }.await()
            callback(data.invoke())
        }
}
