package id.pahlevikun.ilt2.sample.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import id.pahlevikun.ilt2.sample.BaseChildActivity
import id.pahlevikun.ilt2.sample.R
import id.pahlevikun.ilt2.sample.intent.model.Person

class IntentMainActivity :
    BaseChildActivity(),
    View.OnClickListener {

    private lateinit var tvResult: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == IntentMoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue = result.data?.getIntExtra(IntentMoveForResultActivity.EXTRA_SELECTED_VALUE, 0) ?: 0
            tvResult.text = getString(R.string.intent_result, selectedValue.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@IntentMainActivity, IntentMoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveWithDataIntent =
                    Intent(this@IntentMainActivity, IntentMoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(IntentMoveWithDataActivity.EXTRA_NAME, "Farhan Pahlevi")
                moveWithDataIntent.putExtra(IntentMoveWithDataActivity.EXTRA_AGE, 26)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_activity_object -> {
                val person = Person(
                    name = "Farhan Pahlevi",
                    age = 26,
                    email = "farhan.pahlevi@gojek.com",
                    city = "Bogor"
                )

                val moveWithObjectIntent =
                    Intent(this@IntentMainActivity, IntentMoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(IntentMoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dial_number -> {
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$PHONE_NUMBER"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent =
                    Intent(this@IntentMainActivity, IntentMoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }

    companion object {
        private const val PHONE_NUMBER = "081210841382"
    }
}
