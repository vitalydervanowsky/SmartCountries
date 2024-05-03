package by.dzrvnsk.smartcountries.presentation.model

import android.content.Context
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import by.dzrvnsk.smartcountries.R

/**
 * Диалог для отображения прогресса
 */
class SimpleProgressDialog(context: Context) : AppCompatDialog(context) {

    init {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_simple_progress)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }
}