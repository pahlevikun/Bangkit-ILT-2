package id.pahlevikun.ilt2.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import id.pahlevikun.ilt2.sample.R

class FrgHomeFragment :
    Fragment(),
    View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_frg_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory: Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_category) {
            /*
            - addToBackStack will add the fragment into the stack.
            - why need to add null to backstack?
                It will generate a specific back button behavior:
                - If there's a fragment left on the stack, then it will be closed whenever user click on back button
                - If there's no fragment left on the stack, it will pop the activity
             */
            val mCategoryFragment = FrgCategoryFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_container,
                    mCategoryFragment,
                    FrgCategoryFragment::class.java.simpleName
                )
                addToBackStack(null)
            }.commit()
        }
    }
}
