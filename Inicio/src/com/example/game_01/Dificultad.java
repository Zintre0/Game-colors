package com.example.game_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Dificultad extends Activity{

	Intent intent = new Intent();
	RadioButton rb1,rb2,rb3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dificultad2);
		rb1 = (RadioButton) findViewById(R.id.facil);
		rb2 = (RadioButton) findViewById(R.id.medio);
		rb3 = (RadioButton) findViewById(R.id.dificil);
		
	}
	
	public void Facil(View view){
		rb1.setChecked(true);
		intent.putExtra("resultado",65);
	    setResult(RESULT_OK, intent);
	    finish();
	}
	
	public void Medio(View view){
		rb2.setChecked(true);
		intent.putExtra("resultado",45);
	    setResult(RESULT_OK, intent);
	    finish();
	}
	
	public void Dificil(View view){
		rb3.setChecked(true);
		intent.putExtra("resultado",25);
	    setResult(RESULT_OK, intent);
	    finish();
	}
		

}
