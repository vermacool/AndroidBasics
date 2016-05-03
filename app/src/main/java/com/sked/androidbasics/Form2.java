package com.sked.androidbasics;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;


public class Form2 extends Activity {
    TextView name;
    TextView mobile;
    TextView email;
    TextView address;
    ImageView img;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

        name = (TextView) findViewById(R.id.name);
        mobile = (TextView) findViewById(R.id.mobileNo);
        email = (TextView) findViewById(R.id.emailid);
        address = (TextView) findViewById(R.id.address);
        Intent intent = getIntent();
        CharSequence valueName = intent.getCharSequenceExtra("name");
        CharSequence valueMob = intent.getCharSequenceExtra("mobile");
        CharSequence valueMail = intent.getCharSequenceExtra("email");
        CharSequence valueAdd = intent.getCharSequenceExtra("address");
        String valueImageName = intent.getStringExtra("imageName");

        name.setText(valueName);
        mobile.setText(valueMob);
        email.setText(valueMail);
        address.setText(valueAdd);

        img = (ImageView) findViewById(R.id.photo);
         setImage(valueImageName);
    }
    private void setImage(String imageName) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_form2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String path = Environment.getExternalStorageDirectory() + "/" + imageName;
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        if (bitmap != null) {
            img.setImageBitmap(bitmap);
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
