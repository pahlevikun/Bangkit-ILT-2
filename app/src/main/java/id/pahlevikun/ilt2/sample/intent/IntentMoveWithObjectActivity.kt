package id.pahlevikun.ilt2.sample.intent

import android.os.Bundle
import android.widget.TextView
import id.pahlevikun.ilt2.sample.BaseChildActivity
import id.pahlevikun.ilt2.sample.R
import id.pahlevikun.ilt2.sample.intent.model.Person

class IntentMoveWithObjectActivity : BaseChildActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)
        val (name, age, email, city) = intent?.getParcelableExtra(EXTRA_PERSON) as? Person
            ?: Person.empty

        tvObject.text = getString(R.string.intent_object_copies, name, email, age.toString(), city)
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}
