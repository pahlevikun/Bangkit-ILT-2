package id.pahlevikun.ilt2.sample.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import id.pahlevikun.ilt2.sample.R
import id.pahlevikun.ilt2.sample.databinding.FragmentNavigationHomeBinding

class NavigationHomeFragment : Fragment() {

    private val viewBinding: FragmentNavigationHomeBinding by lazy {
        FragmentNavigationHomeBinding.inflate(layoutInflater)
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
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.navigation_component_home_fragment)
        viewBinding.btnCategory.setOnClickListener {
            findNavController().navigate(R.id.second)
        }
    }

}
