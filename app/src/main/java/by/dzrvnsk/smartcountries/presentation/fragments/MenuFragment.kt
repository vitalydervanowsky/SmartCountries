package by.dzrvnsk.smartcountries.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SCALE_IN
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.presentation.model.BaseFragment

class MenuFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.learnButton).setOnClickListener {
            showListFragment()
        }
        view.findViewById<Button>(R.id.testButton).setOnClickListener {
            doOnTestClick()
        }
    }

    private fun showListFragment() {
        findNavController().navigate(
            R.id.action_menuFragment_to_listFragment,
            bundleOf(),
            NAV_OPTIONS_ANIMATION_SCALE_IN
        )
    }

    private fun doOnTestClick() {
        if (sharedPrefs.getString(USER_PREFS, "")?.isEmpty() == true) {
            showLoginFragment()
        } else {
            showHelloFragment()
        }
    }

    private fun showHelloFragment() {
        findNavController().navigate(
            R.id.action_menuFragment_to_helloFragment,
            bundleOf(),
            NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
        )
    }

    private fun showLoginFragment() {
        findNavController().navigate(
            R.id.action_menuFragment_to_loginFragment,
            bundleOf(),
            NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
        )
    }
}
