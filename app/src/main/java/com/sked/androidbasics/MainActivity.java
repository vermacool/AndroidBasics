package com.sked.androidbasics;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.sked.androidbasics.musicplayer.Library;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;


public class MainActivity extends Activity {

    AdapterView.OnItemClickListener onItemClickListener;

    {
        onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ComponentName componentName = null;
                switch (position) {
                    case 0:
                        componentName = new ComponentName(MainActivity.this, TestActivity.class);
                        break;
                    case 1:
                        componentName = new ComponentName(MainActivity.this, FormActivity.class);
                        break;
                    case 2:
                        componentName = new ComponentName(MainActivity.this, BrowserActivity.class);
                        break;
                    case 3:
                        componentName = new ComponentName(MainActivity.this, Library.class);

                        break;
                    case 4:
                        componentName = new ComponentName(MainActivity.this, StringOperationsActivity.class);
                        break;
                    case 5:
                        componentName = new ComponentName(MainActivity.this, MapsActivity.class);
                        break;
                    case 6:
                        componentName = new ComponentName(MainActivity.this, LocationActivity.class);
                        break;
                    case 7:
                        componentName = new ComponentName(MainActivity.this, Name.class);
                        break;
                    case 8:
                        componentName = new ComponentName(MainActivity.this, GetResult.class);
                        break;
                    case 9:
                        componentName= new ComponentName(MainActivity.this,ScrollingActivity.class);
                        break;
                    case 10:
                        componentName = new ComponentName(MainActivity.this, CredentialActivity.class);
                        break;
                    case 11:
                        componentName=new ComponentName(MainActivity.this,Counter.class);
                        break;

                    case 12:
                        componentName =new ComponentName(MainActivity.this,CaptureActivity.class);
                        break;
                    case 13:
                        componentName=new ComponentName(MainActivity.this,PopUpActivity.class);
                        break;
                }
                if (componentName != null) {
                    Intent intent = new Intent();
                    intent.setComponent(componentName);
                    startActivity(intent);
                }
                //Toast.makeText(MainActivity.this, "Clicked itme " + position, Toast.LENGTH_LONG).show();

            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.gridView);

        String[] classes = new String[]{"1:View xml Introduction",
                "2:Simple Form",
                "3:Browser",
                "4:music player",
                "5:stringOperation", "6:AndroidAPI", "7:Gps work", "8:Friends details",
                "9:get result activity", "10:Scrolling Activity", "11:Database Test","12:Counter","13:Capture Image","14:Pop Up"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.grid_item, R.id.text1, classes);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
