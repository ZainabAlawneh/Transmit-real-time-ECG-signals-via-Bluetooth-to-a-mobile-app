package com.example.android.bluetoothlegatt;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class DataNotification extends Application {
    public static final String Channel_ID = "FinalProject_1";

    @Override
    public void onCreate() {
        super.onCreate();

        creatNotificationChannel();
    }

    private void creatNotificationChannel() {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {

            NotificationChannel ServiveNotification = new NotificationChannel(Channel_ID,
                    "FinalProjectNotificatoin",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(ServiveNotification);
        }
    }

}

