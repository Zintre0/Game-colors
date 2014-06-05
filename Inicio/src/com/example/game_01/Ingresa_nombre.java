package com.example.game_01;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ingresa_nombre extends Activity{

	EditText et1;
	int aciertos=0,fallos=0;
	TextView ptj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.ingresa_name);
		
		et1 = (EditText) findViewById(R.id.edit_nombre);
		ptj = (TextView) findViewById(R.id.tv_tu_ptj);
		Bundle extras = getIntent().getExtras();
	    aciertos = extras.getInt("aciertos");
		fallos = extras.getInt("fallos");
		
		ptj.setText("Tu puntaje es de: "+Integer.toString(aciertos-fallos));
	}

	public void Validar(View view){
		finish();
		Intent i = new Intent(this,Score.class);
		i.putExtra("aciertos", aciertos);
		i.putExtra("fallos", fallos);
		i.putExtra("name", et1.getText().toString());
		i.putExtra("origen", "ingresa");
		startActivity(i);
	}
	
}
