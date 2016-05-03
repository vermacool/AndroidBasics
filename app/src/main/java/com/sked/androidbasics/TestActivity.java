package com.sked.androidbasics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by manish on 9/25/2015.
 */
public class TestActivity extends Activity {
    TextView textView;
    Button button;
    TextView homeAddress;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Add you own layout view
        setContentView(R.layout.activity_test);
        textView = (TextView) findViewById(R.id.name);
        textView.setOnClickListener(onClickListener);

        homeAddress = (TextView) findViewById(R.id.address);
        homeAddress.setText("This may be an address.");
        homeAddress.setOnClickListener(onClickListener);

        button = (Button) findViewById(R.id.button);
        button.setText("You can click me");
        button.setOnClickListener(onClickListener);

        editText  = (EditText)findViewById(R.id.editText);


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.name:
                    textView.setText("Just textView clicked");
                    break;
                case R.id.button:

                    CharSequence text = editText.getText();
                    button.setText(text);
                    break;
                case R.id.address:
                    homeAddress.setText("Just address clicked");
                    break;
            }
        }
    };
}
