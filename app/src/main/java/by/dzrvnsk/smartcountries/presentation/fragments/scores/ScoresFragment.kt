package by.dzrvnsk.smartcountries.presentation.fragments.scores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.presentation.model.BaseFragment
import com.afollestad.materialdialogs.MaterialDialog
import org.koin.android.ext.android.inject

class ScoresFragment : BaseFragment() {

    private val viewModel: ScoresViewModel by inject()

    private var adapter: ScoresAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_scores, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ScoresAdapter(emptyList())
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
        view.findViewById<Button>(R.id.deleteButton).setOnClickListener {
            showResetDialog()
        }
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.scores.observe(viewLifecycleOwner) {
            adapter?.setItems(it)
        }
    }

    private fun showResetDialog() {
        MaterialDialog(requireContext()).apply {
            message(R.string.reset_scores_question_message)
            positiveButton(R.string.yes) {
                viewModel.resetResults()
                adapter?.setItems(emptyList())
            }
            negativeButton(R.string.no)
        }.also {
            it.show()
        }
    }
}
