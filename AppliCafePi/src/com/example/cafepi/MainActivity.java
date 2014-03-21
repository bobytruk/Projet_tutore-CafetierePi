/* PROJET TUTEURE CAFEPI
 * SZAMVEBER MATTHIAS
 * FREIN MATHIAS
 * LAYOUT D'INTRO DE L'APPLICATION*/

package com.example.cafepi;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
//import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends Activity {

	@SuppressLint("CutPasteId")
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	  //Affichage de l'image du logo  
	    ImageView image = (ImageView)findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.ic_1);
	    
	     //Affichage du texte de presentation    
	    TextView monTexte = (TextView)findViewById(R.id.textView1);
	    monTexte.setText("Bienvenu dans l'application CafetierePi"+" Projet Tuteuré "+"LP SEICOM 2013/2014");
	    
	//Click sur le bouton genere une nouvelle activité vers le second layout
	Button Bouton1 = (Button)findViewById(R.id.button1);
	Bouton1.setOnClickListener(new OnClickListener() {
	 @Override
		 public void onClick(View v) {
		 	Intent t = new Intent(MainActivity.this, Intro.class); //déclaration de notre nouvelle activité
			startActivity(t); 
		 }});
		
	};}
	


