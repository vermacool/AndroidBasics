package com.sked.androidbasics;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class ReturnResult extends Activity {

    private static final String KEY_RESULT = "key_result";
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_result);
        Button button = (Button) findViewById(R.id.result);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) findViewById(checkedRadioButtonId);
            CharSequence result = "Cannot Process the request!";
            if (checkedRadioButton != null) {
                result = checkedRadioButton.getText();
            }
            Intent intent = new Intent();
            intent.putExtra("key_result", result);
            setResult(RESULT_OK, intent);
            finish();

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_return_result, menu);
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
