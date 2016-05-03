package com.sked.androidbasics;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

import java.io.IOException;

public class MyService extends Service {
    public MyService() {

    }

    MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            if (intent.hasExtra("key_song_id")) { //Checking if intent is having the key "key_song_id" or not
                int songId = intent.getIntExtra("key_song_id", 0);//Getting the song id
                playSongs(songId);//Playing the song
            } else if (intent.hasExtra("key_action")) {//Checking if the intent is having the key "key_action" or not
                int action = intent.getIntExtra("key_action", 0);//(if key "key_action" is available in the intent) getting
                // the value for the key "key_action"
                switch (action) {
                    case 0:
                        stopSong();
                        break;
                    case 1:
                        toggle();
                        break;
                }
            }
        }
        return START_STICKY;
    }


    private void toggle() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        }
    }

    private void stopSong() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    void playSongs(int tonerawId) {
        try {
            mediaPlayer.reset();
            Uri dataSource = Uri.parse("android.resource://" + getPackageName()
                    + "/" + tonerawId);
            //Uri uri = Uri.parse(Environment.getExternalStorageDirectory()+"/Songs.mp3");

            mediaPlayer.setDataSource(this, dataSource);
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
