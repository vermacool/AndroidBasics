package sked.com.core;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

/**
 * Created by manish on 2/28/2016.
 */
public class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected ActionBar actionBar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();
        }
    }
}
