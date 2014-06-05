package com.example.game_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Como_Jugar extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.como_jugar2);
	}
	
	public void Salir(View view){
		finish();
	}
}
