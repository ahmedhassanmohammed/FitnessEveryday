package app.sunshine.com.example.android.fitnesseveryday.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import app.sunshine.com.example.android.fitnesseveryday.History;
import app.sunshine.com.example.android.fitnesseveryday.R;

/**
 * Implementation of App Widget functionality.
 */
public class FitnessWidgetProvider extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.fitness_widget_provider);




        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        final int N = appWidgetIds.length;
        for (int i = 0; i < N; ++i) {

            //which layout to show on widget
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.fitness_widget_provider);

            //RemoteViews Service needed to provide adapter for ListView
            Intent intent = new Intent(context, ListWidgetService.class);
            //passing app widget id to that RemoteViews Service
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            //setting a unique Uri to the intent
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            //setting adapter to listview of the widget
            remoteViews.setRemoteAdapter(appWidgetIds[i], R.id.widget_ListView, intent);
            //setting an empty view in case of no data
            remoteViews.setEmptyView(R.id.widget_ListView, R.id.empty_view);

            Intent intent2 = new Intent(context, History.class);
            intent2.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent2, 0);
            remoteViews.setPendingIntentTemplate(R.id.Historywidget, pendingIntent);


            appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
            //      return remoteViews;
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

}

