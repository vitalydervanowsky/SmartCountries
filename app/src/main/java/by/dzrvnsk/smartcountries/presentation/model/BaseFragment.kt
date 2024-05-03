package by.dzrvnsk.smartcountries.presentation.model

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    private var blockingProgressDialog: SimpleProgressDialog? = null

    val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
    }
    override fun onDestroyView() {
        hideBlockingLoadingProgress()
        super.onDestroyView()
    }

    fun showBlockingLoadingProgress() {
        if (blockingProgressDialog == null) {
            blockingProgressDialog = SimpleProgressDialog(requireContext()).apply { show() }
        }
    }

    fun hideBlockingLoadingProgress() {
        blockingProgressDialog?.dismiss()
        blockingProgressDialog = null
    }

    fun showToastInfo(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val USER_PREFS = "USER_PREFS"
    }
}