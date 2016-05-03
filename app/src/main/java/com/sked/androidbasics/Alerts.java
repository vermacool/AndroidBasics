package com.sked.androidbasics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

public class Alerts extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        AlertDialog alertDialog = new AlertDialog.Builder(
                Alerts.this).create();
        // Setting Dialog Title
        alertDialog.setTitle("Alert Dialog");

        // Setting Dialog Message
        alertDialog.setMessage("Welcome to AndroidHive.info");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.mr_ic_pause_dark);
        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
            }
        });
        // Showing Alert Message
        alertDialog.show();}

}
