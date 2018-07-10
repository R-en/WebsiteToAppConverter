package com.example.android.easyonlineconverter;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // myWebView = (WebView) findViewById(R.id.webView);
       // WebSettings webSettings= myWebView.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        // Line of Code for opening links in app
        //myWebView.setWebViewClient(new WebViewClient());
        //myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        //myWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        //myWebView.setWebChromeClient(new WebChromeClient());
        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setSupportMultipleWindows(true);
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                setProgressBarIndeterminateVisibility(false);
                super.onPageFinished(view, url);
            }
        });
        //myWebView.loadUrl("https://www.youtube.com/");
        myWebView.setVisibility(View.VISIBLE);
        myWebView.loadUrl("https://www.cnn.com/2018/07/02/us/toys-r-us-buyer-donation-trnd/index.html");
    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack())
        {
            myWebView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
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
