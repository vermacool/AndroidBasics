package com.sked.androidbasics;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class GetResult extends Activity {

    private static final int REQUEST_CODE = 1234;
    private static final String KEY_RESULT = "key_result";
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Enabling back button on the ActionBar
       /* ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }*/
        setContentView(R.layout.activity_get_result);
        Button button = (Button) findViewById(R.id.resultsbutton);
        result = (TextView) findViewById(R.id.resultstextView);
        button.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //startActivityForResult method is used to start an Activity who returns some result.
            //The result is returned in the method onActivityResult on an Intent
            Intent intent = new Intent(GetResult.this, ReturnResult.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //  noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            //TODO:Implement the logic to get the data from intent
            //Intent intent=getIntent();


            Toast.makeText(this, "Result returned", Toast.LENGTH_LONG).show();
            CharSequence resultValue = data.getCharSequenceExtra("key_result");
            result.setText(resultValue);
        }
    }
}
