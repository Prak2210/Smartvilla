package com.example.vasu_pc.trails;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * A login screen that offers login via email/password.
 */


public class Streaming extends Activity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        WebView web=(WebView)findViewById(R.id.webView);
        web.loadUrl("http://www.google.com/");

    }

}






