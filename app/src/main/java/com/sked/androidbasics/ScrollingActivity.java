package com.sked.androidbasics;

import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import sked.com.core.BaseActivity;

public class ScrollingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_scrolling);
        actionBar.setTitle("This is from module core");
    }
}
