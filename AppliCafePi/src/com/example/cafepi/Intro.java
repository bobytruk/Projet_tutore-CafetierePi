/* PROJET TUTEURE CAFEPI
 * SZAMVEBER MATTHIAS
 * FREIN MATHIAS
 * LAYOUT DE CONNECTION*/
package com.example.cafepi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Intro extends Activity {
	
	public EditText editText;
	private Button button;
	public String identifiant;
	//private EditText identifiant;
	private EditText password;
	
@Override
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.intro);
	        
	        editText = (EditText) findViewById(R.id.EditTextPrenom);
	        password = (EditText) findViewById(R.id.editTextPasswd);
	       // identifiant = (EditText) findViewById(R.id.EditTextPrenom);
	        button = (Button) findViewById(R.id.buttonEnvoyer);
	        
	        button.setOnClickListener(new OnClickListener() {
	        		public void onClick(View v) {
	        			identifiant = editText.getText().toString();
	        			
	        				if(password.getText().toString().equals("cafepi") && (identifiant.toString().equals("user1"))){
	        					//Toast.makeText(Intro.this, "Bonjour " + identifiant + " !", Toast.LENGTH_LONG).show();
	        				Intent t = new Intent(Intro.this, WebView.class);
	        				startActivity(t);
	        				}else{	Toast.makeText(Intro.this, "Erreur de connexion !", Toast.LENGTH_LONG).show();}

	        		}});
	        
	        //retour au premier layout
	        Button Bouton1 = (Button)findViewById(R.id.button1);
	    	Bouton1.setOnClickListener(new OnClickListener() {
	    	public void onClick(View v) {
				finish();
				
			 };
	    });
	}}
	

