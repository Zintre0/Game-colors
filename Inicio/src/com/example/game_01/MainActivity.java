package com.example.game_01;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	Button top,bot,left,right,center;
	TextView tx1;
	int alea,aciertos=0,fallos=0,maximo=0,v=10;
	MediaPlayer mPlayer,mp2;
	Accion ac = new Accion(this);
	
	boolean entrar = false;
	
	SoundPool sp;

	private long startTime = 0L;

	private Handler customHandler = new Handler();

	long timeInMilliseconds = 0L;
	long timeSwapBuff = 0L;
	long updatedTime = 0L;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cads);
		
		top = (Button) findViewById(R.id.top);
		bot = (Button) findViewById(R.id.bot);
		left = (Button) findViewById(R.id.left);
		right = (Button) findViewById(R.id.right);
		center = (Button) findViewById(R.id.center);
		tx1 = (TextView) findViewById(R.id.segundero);
		
		//top.setBackgroundColor(Color.GREEN);
		//bot.setBackgroundColor(Color.RED);
		//left.setBackgroundColor(Color.CYAN);
		//right.setBackgroundColor(Color.YELLOW);
		
		
		top.setOnClickListener(this);
		bot.setOnClickListener(this);
		left.setOnClickListener(this);
		right.setOnClickListener(this);
		
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		int soundId = sp.load(this, R.raw.song, 1); // in 2nd param u have to pass your desire ringtone
		sp.play(soundId, 1, 1, 0, 0, 1);
		mPlayer = MediaPlayer.create(this, R.raw.bubble2); // in 2nd param u have to pass your desire ringtone
		mp2 = MediaPlayer.create(this, R.raw.housepiano); // in 2nd param u have to pass your desire ringtone
		
		 //mPlayer.prepare();
		
		
		startTime = SystemClock.uptimeMillis();
		customHandler.postDelayed(updateTimerThread, 0);
		
		Bundle extras = getIntent().getExtras();
		maximo = extras.getInt("Valor", 65);
		
		center.setText("Aciertos: "+aciertos+"  Fallos: "+fallos);
		alea = (int)(Math.random()*4);
		ac.desorden(alea);
		
	}
	
	


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		timeSwapBuff += timeInMilliseconds;
		customHandler.removeCallbacks(updateTimerThread);
		finish();
	}

	


	/*@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		startTime = SystemClock.uptimeMillis();
		customHandler.postDelayed(updateTimerThread, 0);
		
	}*/

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		timeSwapBuff += timeInMilliseconds;
		customHandler.removeCallbacks(updateTimerThread);
		finish();
	}




	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.top:
			this.mPlayer.start();
			if (1==alea)
				aciertos++;
			else
				fallos++;
			alea = (int)(Math.random()*4);
			ac.desorden(alea);
			center.setText("Aciertos: "+aciertos+"  Fallos: "+fallos);
			break;
		case R.id.bot:
			this.mPlayer.start();
			if (0==alea)
				aciertos++;
			else
				fallos++;
			alea = (int)(Math.random()*4);
			ac.desorden(alea);
			center.setText("Aciertos: "+aciertos+"  Fallos: "+fallos);
			break;
		case R.id.left:
			this.mPlayer.start();
			if (3==alea)
				aciertos++;
			else
				fallos++;
			alea = (int)(Math.random()*4);
			ac.desorden(alea);
			center.setText("Aciertos: "+aciertos+"  Fallos: "+fallos);
			break;
		case R.id.right:
			this.mPlayer.start();
			if (2==alea)
				aciertos++;
			else
				fallos++;
			alea = (int)(Math.random()*4);
			ac.desorden(alea);
			center.setText("Aciertos: "+aciertos+"  Fallos: "+fallos);
			break;
			
		}
		/*if (aciertos == maximo){
			finish();
			Intent i = new Intent(this,Ingresa_nombre.class);
			i.putExtra("aciertos", aciertos);
			i.putExtra("fallos", fallos);
			startActivity(i);
		}*/
		
	}
	
	private void endGame(){
		mp2.start();
		finish();
		Intent i = new Intent(this,Ingresa_nombre.class);
		i.putExtra("aciertos", aciertos);
		i.putExtra("fallos", fallos);
		startActivity(i);
	}
	
	private Runnable updateTimerThread = new Runnable() {

		public void run() {

			timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

			updatedTime = timeSwapBuff + timeInMilliseconds;
			
			int cont_secs =0;
			//int secs = (int) (updatedTime / 1000);
			int secs2 = (int) (updatedTime / 1000);
			int mins = secs2 / 60;
			//secs = secs % 60;
			int milliseconds = (int) (updatedTime % 1000);
			tx1.setText(String.format("%02d", maximo-secs2)+" seg");
			//top.setText(String.format("%02d", maximo-secs2)+" seg");
			if (maximo-secs2 == 0){
				endGame();
				timeSwapBuff += timeInMilliseconds;
				customHandler.removeCallbacks(updateTimerThread);
			}
			else
				customHandler.postDelayed(this, 0);
		}

	};

}
