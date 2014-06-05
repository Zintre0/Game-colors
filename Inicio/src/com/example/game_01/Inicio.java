package com.example.game_01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Inicio extends Activity{

	int valor;
	Animation animacion_btn,anim2,anim3;
	Button btn_play,btn_difi,btn_howplay,btn_score;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio);
		
		btn_play =(Button) findViewById(R.id.jugar);
		btn_difi =(Button) findViewById(R.id.dificultad);
		btn_howplay =(Button) findViewById(R.id.como_jugar);
		btn_score = (Button) findViewById(R.id.Score);
		
		animacion_btn = AnimationUtils.loadAnimation(this,R.anim.amin_type);
		anim2 = AnimationUtils.loadAnimation(this,R.anim.left);
		anim3 = AnimationUtils.loadAnimation(this,R.anim.type);
		
		//Seccion para animar
		/*btn_play.startAnimation(animacion_btn);
		btn_difi.startAnimation(anim2);
		btn_howplay.startAnimation(anim3);
		btn_score.startAnimation(anim3);*/
		
		valor=65;
	}
	
	public void Play(View view){
		Intent i = new Intent(this,MainActivity.class);
		i.putExtra("Valor", valor);
		startActivityForResult(i, 1111);
	}
	
	public void Dificultad(View view){
		Intent i = new Intent(this,Dificultad.class);
		startActivityForResult(i, 1234);
	}
	
	public void Como_Jugar(View view){
		Intent i = new Intent(this,Como_Jugar.class);
		startActivity(i);
	}
	
	public void Exit(View view){
		finish();
	}
	
	public void Puntajes(View view){
		Intent i = new Intent(this,Score.class);
		i.putExtra("aciertos", 0);
		i.putExtra("fallos", 0);
		i.putExtra("name", "Hola");
		i.putExtra("origen", "inicio");
		startActivity(i);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==1234 && resultCode==RESULT_OK) {
            valor = data.getExtras().getInt("resultado");
		 }
	}
	
	

}
