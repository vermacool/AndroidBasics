package com.sked.androidbasics.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sked.androidbasics.MyService;
import com.sked.androidbasics.R;

import java.io.IOException;


public class Library extends Activity {
    String[] names;
    int[] songs;
    MediaPlayer mediaPlayer;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librery);
        mediaPlayer = new MediaPlayer();
        //Setting the ListView Reference
        ListView listView = (ListView) findViewById(R.id.listView);

        //Setting the Choice Mode to the ListVIew
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        //Creating an Array of Strings/ DataSet
        names = new String[]{"bangistan_maula.mp3",
                "dil_dhadakne_do.mp3",
                "gallan_goodiyaan.mp3"};
        songs = new int[]{R.raw.bangistan_maula,
                R.raw.dil_dhadakne_do,
                R.raw.gallan_goodiyaan
        };


        //Creating an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, names);

        //Setting adapter to the ListView
        listView.setAdapter(adapter);

        //Setting Click Listener to the ListView

        listView.setOnItemClickListener(onItemClickListener);

    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(Library.this, "Item on position " + names[position] + " is clicked", Toast.LENGTH_LONG).show();
            //playSongs(songs[position]);
            Intent intent = new Intent(Library.this, MyService.class);
            intent.putExtra("key_song_id", songs[position]);
            startService(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_librery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_stop) {
            //Sending action to perform stop/start on the Media Player instance
            Intent intent = new Intent(Library.this, MyService.class);
            intent.putExtra("key_action", 1);
            startService(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    void playSongs(int songsRawId) {
        try {
            mediaPlayer.reset();
            Uri dataSource = Uri.parse("android.resource://" + getPackageName()
                    + "/" + songsRawId);
            //Uri uri = Uri.parse(Environment.getExternalStorageDirectory()+"/Songs.mp3");

            mediaPlayer.setDataSource(this, dataSource);
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
