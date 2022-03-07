package id.pahlevikun.ilt2.sample.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import id.pahlevikun.ilt2.sample.R
import id.pahlevikun.ilt2.sample.databinding.FragmentNavigationSecondBinding

class NavigationSecondFragment : Fragment() {

    private val viewBinding: FragmentNavigationSecondBinding by lazy {
        FragmentNavigationSecondBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.title = getString(R.string.navigation_component_second_fragment)
    }

}
