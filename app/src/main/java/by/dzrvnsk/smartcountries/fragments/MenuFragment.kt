package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("LAST_LOGIN", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLearn.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.scale_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.scale_out
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, ListFragment())
                    .commit()
            }

            val lastLogin = sharedPrefs.getString("LAST_USER_NAME", "")

            if (lastLogin?.length!! > 0) {
                btnTest.setOnClickListener {
                    parentFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.slide_in_bottom,
                            R.anim.fade_out,
                            R.anim.fade_in,
                            R.anim.slide_out_bottom
                        )
                        .addToBackStack(null)
                        .replace(R.id.container, HelloFragment())
                        .commit()
                }
            } else {
                btnTest.setOnClickListener {
                    parentFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.slide_in_bottom,
                            R.anim.fade_out,
                            R.anim.fade_in,
                            R.anim.slide_out_bottom
                        )
                        .addToBackStack(null)
                        .replace(R.id.container, LoginFragment())
                        .commit()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}