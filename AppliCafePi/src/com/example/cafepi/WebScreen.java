/* PROJET TUTEURE CAFEPI
 * SZAMVEBER MATTHIAS
 * FREIN MATHIAS
 * LAYOUT D'AFFICHAGE DU CONTENU WEB*/
package com.example.cafepi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.util.Log;

public class WebScreen extends Activity {

    public static final String URL = "";
    private static final String TAG = "Class Webscreen";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webscreen);
             
        WebView Mywebview = (WebView) findViewById (R.id.webView1);
        WebSettings webSettings = Mywebview.getSettings();
        Mywebview.loadUrl("http://192.168.42.1:8000");
        webSettings.setJavaScriptEnabled(true);
    
    Button Bouton1 = (Button)findViewById(R.id.button1);
	Bouton1.setOnClickListener(new OnClickListener() {
	public void onClick(View v) {
		finish();
		}});
		
}}
		