package id.pahlevikun.ilt2.sample.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import id.pahlevikun.ilt2.sample.R

class FrgCategoryDetailsFragment : Fragment() {

    private lateinit var tvCategoryName: TextView
    private lateinit var tvCategoryDescription: TextView
    private lateinit var btnProfile: Button
    private lateinit var btnShowDialog: Button

    private var title: String = ""
    private var description: String = ""

    internal var optionDialogListener: FrgOptionDialogFragment.OnOptionDialogListener = object :
        FrgOptionDialogFragment.OnOptionDialogListener {
        override fun onOptionChosen(text: String?) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_frg_category_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initCta()
        initValueFromArgsIfAvailable()
    }

    private fun initViews(view: View) {
        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
    }

    private fun initCta() {
        btnProfile.setOnClickListener {
            val mIntent = Intent(requireContext(), FrgProfileActivity::class.java)
            startActivity(mIntent)
        }
        btnShowDialog.setOnClickListener {
            val mOptionDialogFragment = FrgOptionDialogFragment.newInstance()
            val mFragmentManager = childFragmentManager
            mOptionDialogFragment.show(mFragmentManager,
                FrgOptionDialogFragment::class.java.simpleName)
        }
    }

    private fun initValueFromArgsIfAvailable() {
        if (arguments != null) {
            title = arguments?.getString(KEY_TITLE).orEmpty()
            description = arguments?.getString(KEY_DESCRIPTION).orEmpty()
            tvCategoryName.text = title
            tvCategoryDescription.text = description
        }
    }

    companion object {
        private const val KEY_TITLE = "key.extra.title"
        private const val KEY_DESCRIPTION = "key.extra.description"

        fun newInstance(
            title: String,
            description: String,
        ): FrgCategoryDetailsFragment {
            val bundle = Bundle().apply {
                putString(KEY_TITLE, title)
                putString(KEY_DESCRIPTION, description)
            }
            return FrgCategoryDetailsFragment().apply { arguments = bundle }
        }
    }
}
