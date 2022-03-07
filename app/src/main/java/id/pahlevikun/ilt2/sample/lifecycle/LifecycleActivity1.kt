package id.pahlevikun.ilt2.sample.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import id.pahlevikun.ilt2.sample.BaseChildActivity
import id.pahlevikun.ilt2.sample.R

class LifecycleActivity1 : BaseChildActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_1)
        Log.d(TAG, "onCreate: ")
        findViewById<Button>(R.id.btn_cta)?.setOnClickListener {
            startActivity(Intent(this, LifecycleActivity2::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    companion object {
        private const val TAG = "ActivityLifecycle : 1 >"
    }
}