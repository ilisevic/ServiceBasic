package com.boilerplatecode.servicebasic;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import static com.boilerplatecode.servicebasic.App.CHANNEL_ID;

public class ExampleService extends Service {
MediaPlayer mediaPlayer;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override //TODO metod ispod se izvršava po kreiranju  servisa
    //Možda nije loše ovo iskoristiti za zvuk
    public void onCreate() {
        super.onCreate();
    }


    @Override//TODO metod ispod se izvršava po svakom  pokretanju servisa
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");

        Intent notificationIntent =new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);

     //   mediaPlayer= MediaPlayer.create(this,R.raw.emergency );
       // mediaPlayer.start();


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(pendingIntent)
                .build();

startForeground(1,notification);
//TODO ispod za return bitno sta vraća START_NO_STICKY, START_STICKY, START_REDELIVERY_INTENT
return  START_NOT_STICKY;


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}


