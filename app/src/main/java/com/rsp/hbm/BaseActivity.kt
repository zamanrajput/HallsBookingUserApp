package com.rsp.hbm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    fun onMain(runnable: Runnable) {
        runOnUiThread(runnable)
    }


    @OptIn(DelicateCoroutinesApi::class)
    fun onCoroutine(runnable: Runnable) {
        GlobalScope.launch {
            val dispatcher = getDispatcherFromCurrentThread(this)
            CoroutineScope(dispatcher).launch {
                runnable.run()
            }
        }
    }


    fun onBgThread(runnable: Runnable) {
        Thread {
            runnable.run()
        }
    }


    private fun getDispatcherFromCurrentThread(scope: CoroutineScope): CoroutineContext {
        return scope.coroutineContext
    }


}