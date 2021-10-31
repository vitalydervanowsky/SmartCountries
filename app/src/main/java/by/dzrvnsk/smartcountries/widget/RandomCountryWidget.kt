package by.dzrvnsk.smartcountries.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.widget.RemoteViews
import by.dzrvnsk.smartcountries.*
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
    val sharedPrefs = context.getSharedPreferences(RANDOM_COUNTRY, Context.MODE_PRIVATE)
    val name = sharedPrefs.getString(RANDOM_COUNTRY_NAME, NO_COUNTRY_NAME)
    val flag = sharedPrefs.getString(RANDOM_COUNTRY_FLAG, NO_COUNTRY_FLAG)

    val views = RemoteViews(context.packageName, R.layout.random_country_widget)

    if (name != NO_COUNTRY_NAME) {
        views.setTextViewText(R.id.tv_country_name, name)
    }
    if (flag != NO_COUNTRY_FLAG) {
        val awt: AppWidgetTarget = object :
            AppWidgetTarget(context.applicationContext, R.id.iv_country_flag, views, appWidgetId) {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                super.onResourceReady(resource, transition)
            }
        }
        Glide.with(context.applicationContext)
            .asBitmap()
            .load(flag)
            .into(awt)
    }

    val intent = Intent(context, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
    views.setOnClickPendingIntent(R.id.widget, pendingIntent)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}