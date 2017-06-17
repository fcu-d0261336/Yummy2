package com.example.niu.yummy;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by 路人 on 2017/6/17.
 */

public class WebViewActivity extends Activity {
    public static final String WEB_URL="url";
    private WebView wv_content;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        wv_content=(WebView)findViewById(R.id.wv_content);
        getBundleData();
        initData();
    }
    private void  getBundleData(){
        Intent intent=getIntent();
        if(intent!=null) {
            url =intent.getStringExtra(WEB_URL);
        }
    }
    private void initData(){
        WebSettings settings=wv_content.getSettings();
        settings.setJavaScriptEnabled(true);
        wv_content.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        wv_content.loadUrl(url);
    }
}
