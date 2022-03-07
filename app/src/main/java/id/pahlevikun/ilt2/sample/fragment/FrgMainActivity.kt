package id.pahlevikun.ilt2.sample.fragment

import android.os.Bundle
import android.util.Log
import id.pahlevikun.ilt2.sample.BaseChildActivity
import id.pahlevikun.ilt2.sample.R

class FrgMainActivity : BaseChildActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frg_main)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = FrgHomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(FrgHomeFragment::class.java.simpleName)

        /*
        Check if the fragment already initialized, then just skip the initialization, if empty then add the fragment to the stack
         */
        if (fragment !is FrgHomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + FrgHomeFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mHomeFragment, FrgHomeFragment::class.java.simpleName)
                .commit()
        }
    }
}
