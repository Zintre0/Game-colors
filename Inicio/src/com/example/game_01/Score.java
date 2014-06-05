package com.example.game_01;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends Activity{

	TextView tv1,tv2;
	int aciertos=0,fallos=0;
	int aciertos_oa=0,fallos_oa=0;
	String name,name_oa,origen;
	
	SharedPreferences preferencias;
	SharedPreferences.Editor editor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.estadisticas);
		
		preferencias= getPreferences(MODE_PRIVATE);
		editor = preferencias.edit();
		Bundle extras = getIntent().getExtras();
		
		aciertos=preferencias.getInt("aciertos", 0);
		fallos = preferencias.getInt("fallos", 0);
		name = preferencias.getString("name","Mr.default");
		
		tv1 = (TextView) findViewById(R.id.ptj_1);
		tv2 = (TextView) findViewById(R.id.ptj_2);
		
		origen = extras.getString("origen");
		
		if (origen.equals("inicio")){
			aciertos_oa=preferencias.getInt("aciertos_last", 0);
			fallos_oa = preferencias.getInt("fallos_last", 0);
			name_oa = preferencias.getString("name_last","Mr.default");
		}
		else{
			aciertos_oa = extras.getInt("aciertos");
			fallos_oa = extras.getInt("fallos");
			name_oa = extras.getString("name");
		}
		
		
		if (aciertos-fallos>=aciertos_oa - fallos_oa){
			if (aciertos-fallos==aciertos_oa - fallos_oa){
				aciertos = aciertos_oa;
				fallos = fallos_oa;
				name = name_oa;
			}
			/*else{
				aciertos = aciertos;
				fallos = fallos;
				name = name;
			}*/
		}
		else{
			aciertos = aciertos_oa;
			fallos = fallos_oa;
			name = name_oa;
		}
		
		tv1.setText(name+"   Aciertos: "+Integer.toString(aciertos)+"   Fallos: "+Integer.toString(fallos)+"   Puntaje: "+Integer.toString(aciertos-fallos));
		
		tv2.setText(name_oa+"   Aciertos: "+Integer.toString(aciertos_oa)+"   Fallos: "+Integer.toString(fallos_oa)+"   Puntaje: "+Integer.toString(aciertos_oa-fallos_oa));
		
		editor.putInt("aciertos", aciertos);
		editor.putInt("fallos", fallos);
		editor.putString("name", name);
		
		editor.putInt("aciertos_last", aciertos_oa);
		editor.putInt("fallos_last", fallos_oa);
		editor.putString("name_last", name_oa);
		
		editor.commit();
		
	}

	
	
}
