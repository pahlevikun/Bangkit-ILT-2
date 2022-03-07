package id.pahlevikun.ilt2.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import id.pahlevikun.ilt2.sample.fragment.FrgMainActivity
import id.pahlevikun.ilt2.sample.intent.IntentMainActivity
import id.pahlevikun.ilt2.sample.lifecycle.LifecycleActivity1
import id.pahlevikun.ilt2.sample.navigation.NavigationMainActivity
import id.pahlevikun.ilt2.sample.recyclerview.RecyclerViewMainActivity
import id.pahlevikun.ilt2.sample.viewbinding.ViewBindingMainActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.btn_fragment).setOnClickListener {
            open(FrgMainActivity::class.java)
        }
        findViewById<Button>(R.id.btn_intent).setOnClickListener {
            open(IntentMainActivity::class.java)
        }
        findViewById<Button>(R.id.btn_lifecycle).setOnClickListener {
            open(LifecycleActivity1::class.java)
        }
        findViewById<Button>(R.id.btn_recyclerview).setOnClickListener {
            open(RecyclerViewMainActivity::class.java)
        }
        findViewById<Button>(R.id.btn_view_binding).setOnClickListener {
            open(ViewBindingMainActivity::class.java)
        }
        findViewById<Button>(R.id.btn_navigation).setOnClickListener {
            open(NavigationMainActivity::class.java)
        }
    }

    private fun <T> open(clazz: Class<T>) = startActivity(Intent(this, clazz))
}