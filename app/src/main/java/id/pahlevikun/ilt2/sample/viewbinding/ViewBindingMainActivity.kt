package id.pahlevikun.ilt2.sample.viewbinding

import android.os.Bundle
import id.pahlevikun.ilt2.sample.BaseChildActivity
import id.pahlevikun.ilt2.sample.R
import id.pahlevikun.ilt2.sample.databinding.ActivityViewBindingMainBinding

class ViewBindingMainActivity : BaseChildActivity() {

    private var count: Int = 0

    private val view: ActivityViewBindingMainBinding by lazy {
        ActivityViewBindingMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.btnAdd.setOnClickListener {
            count += 1
            view.tvCount.text = getString(R.string.view_binding_count, count.toString())
        }
    }
}