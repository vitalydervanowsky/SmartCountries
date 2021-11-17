package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.LAST_LOGIN
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SCALE_IN
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
import by.dzrvnsk.smartcountries.NO_NAME
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(LAST_LOGIN, Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() = with(binding) {
        btnLearn.setOnClickListener {
            showListFragment()
        }
        btnTest.setOnClickListener {
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
        if (sharedPrefs.getString(LAST_LOGIN, NO_NAME) == NO_NAME) {
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
