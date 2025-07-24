package com.botjeu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private Handler handler = new Handler();
    private Random random = new Random();

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://jeu.passagedudesir.fr/GAM348080616806");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.evaluateJavascript(
                    "(function(){ var evt=new MouseEvent('mousedown',{bubbles:true,cancelable:true,view:window,clientX:window.innerWidth/2,clientY:window.innerHeight/2}); document.dispatchEvent(evt); var evt2=new MouseEvent('mouseup',{bubbles:true,cancelable:true,view:window,clientX:window.innerWidth/2,clientY:window.innerHeight/2}); document.dispatchEvent(evt2); })();", null);
                handler.postDelayed(this, 180 + random.nextInt(100));
            }
        }, 500);
    }
}
