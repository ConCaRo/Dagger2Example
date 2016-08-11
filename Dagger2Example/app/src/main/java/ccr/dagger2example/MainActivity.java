package ccr.dagger2example;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Vehicle vehicle;

    NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
//
        vehicle = component.provideVehicle();

        System.out.print(String.valueOf(vehicle.getSpeed()));
//
//        Toast.makeText(this, String.valueOf(vehicle.getSpeed()), Toast.LENGTH_SHORT).show();

        mNotificationManager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);


        createSimpleNotification(this);

        findViewById(R.id.tvShowNoti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collapseNotification(null);
            }
        });
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        //For 3G check
        boolean is3g = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .isConnectedOrConnecting();
//For WiFi Check
        boolean isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .isConnectedOrConnecting();

        System.out.println(is3g + " net " + isWifi);
    }

    public void createSimpleNotification(Context context) {
        // Creates an explicit intent for an Activity
        Intent resultIntent = new Intent(context, Main2Activity.class);

        // Creating a artifical activity stack for the notification activity
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        // Pending intent to the notification manager
        PendingIntent resultPending = stackBuilder
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // Building the notification
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle("I'm a simple notification") // main title of the notification
                .setContentText("I'm the text of the simple notification") // notification text
                .setContentIntent(resultPending); // notification intent

        // mId allows you to update the notification later on.
        mNotificationManager.notify(10, mBuilder.build());


        // Building the notification
        NotificationCompat.Builder mBuilder1 = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle("I'm a simple  notification 1") // main title of the notification
                .setContentText("I'm the text of the simple notification  1") // notification text
                .setContentIntent(resultPending); // notification intent

        // mId allows you to update the notification later on.
        mNotificationManager.notify(11, mBuilder1.build());
    }

    private void collapseNotification(PendingIntent resultPending) {

        NotificationCompat.InboxStyle notiStyle = new NotificationCompat.InboxStyle();
        notiStyle.addLine("Line 1");
        notiStyle.addLine("Line 2");

        // Building the notification
        NotificationCompat.Builder mBuilder1 = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle("2 questions") // main title of the notification
                .setContentText("Line 1, 2") // notification text
                .setSubText("2 Summary questions")
                .setContentIntent(resultPending); // notification intent


        mBuilder1.setStyle(notiStyle);

        // mId allows you to update the notification later on.
        mNotificationManager.notify(12, mBuilder1.build());
        mNotificationManager.cancel(10);
        mNotificationManager.cancel(11);

    }
}
