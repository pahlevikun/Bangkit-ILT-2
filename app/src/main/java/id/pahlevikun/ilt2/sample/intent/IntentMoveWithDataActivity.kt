package id.pahlevikun.ilt2.sample.intent

import android.os.Bundle
import android.widget.TextView
import id.pahlevikun.ilt2.sample.BaseChildActivity
import id.pahlevikun.ilt2.sample.R

class IntentMoveWithDataActivity : BaseChildActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_move_with_data)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        val name = intent?.getStringExtra(EXTRA_NAME).orEmpty()
        val age = intent?.getIntExtra(EXTRA_AGE, 0) ?: 0

        tvDataReceived.text = getString(R.string.intent_data_copies, name, age.toString())
    }

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
}
