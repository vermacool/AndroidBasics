package com.sked.androidbasics;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class BrowserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        //
        WebView webView = (WebView) findViewById(R.id.web_view);
        //Default
        webView.setWebChromeClient( new WebChromeClient());
        //Ensures the all pages will be in same WebView instead of launching the native browser
        webView.setWebViewClient( new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

       //
        webView.loadUrl("https://www.facebook.com");
    }
      @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_browser, menu);
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
