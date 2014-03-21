/* PROJET TUTEURE CAFEPI
 * SZAMVEBER MATTHIAS
 * FREIN MATHIAS
 * LAYOUT D'INTRO DE L'APPLICATION*/
package com.example.cafepi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.widget.Button;


//import android.webkit.WebView;
	 
	public class WebView extends Activity implements OnClickListener{
		 WebView webview;
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.webview);
	        
	     // Add Click listeners for all buttons
	         View firstButton = findViewById(R.id.button1);
	         firstButton.setOnClickListener(this);
	         View secondButton = findViewById(R.id.button2);
	         secondButton.setOnClickListener(this);              
	    }

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
            case R.id.button1:
                Intent j = new Intent(WebView.this, WebScreen.class);
                startActivity(j);
            break;
            
            case R.id.button2:
            	
    	        			finish();
    	        		
            break;     
        }
	
    }


			
}
	


