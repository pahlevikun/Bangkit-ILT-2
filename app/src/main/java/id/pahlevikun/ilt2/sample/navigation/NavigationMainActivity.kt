package id.pahlevikun.ilt2.sample.navigation

import android.os.Bundle
import id.pahlevikun.ilt2.sample.BaseChildActivity
import id.pahlevikun.ilt2.sample.databinding.ActivityNavigationMainBinding

class NavigationMainActivity : BaseChildActivity() {

    private val view: ActivityNavigationMainBinding by lazy {
        ActivityNavigationMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
    }
}