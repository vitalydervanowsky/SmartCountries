package by.dzrvnsk.smartcountries.presentation.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.widget.RemoteViews
import by.dzrvnsk.smartcountries.presentation.MainActivity
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.presentation.fragments.countrylist.CountryListFragment
import by.dzrvnsk.smartcountries.presentation.model.BaseFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.AppWidgetTarget
import com.bumptech.glide.request.transition.Transition

class RandomCountryWidget : AppWidgetProvider() {
    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        val appWidgetManager = AppWidgetManager.getInstance(context)
        val ids = appWidgetManager.getAppWidgetIds(
            ComponentName(
                context,
                RandomCountryWidget::class.java
            )
        )

        for (appWidgetId in ids) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val sharedPrefs = context.getSharedPreferences(BaseFragment.USER_PREFS, Context.MODE_PRIVATE)
    val name = sharedPrefs.getString(CountryListFragment.RANDOM_COUNTRY_NAME, "")
    val flag = sharedPrefs.getString(CountryListFragment.RANDOM_COUNTRY_FLAG, "")

    val views = RemoteViews(context.packageName, R.layout.random_country_widget)

    if (name?.isEmpty() == false) {
        views.setTextViewText(R.id.countryNameTextView, name)
    }
    if (flag?.isEmpty() == false) {
        Glide.with(context.applicationContext)
            .asBitmap()
            .load(flag)
            .into(
                object : AppWidgetTarget(
                    context.applicationContext,
                    R.id.imageView,
                    views,
                    appWidgetId
                ) {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        super.onResourceReady(resource, transition)
                    }
                }
            )
    }

    val intent = Intent(context, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
    views.setOnClickPendingIntent(R.id.widget, pendingIntent)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}
