package com.example.game_01;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;


public class Accion{
	
	MainActivity man;
	Activity move;
	int valor=0;
	
	public Accion(MainActivity m){
		man = m;
	}
	
	public void desorden(int t){
		switch(t){
			case 0:
				man.center.setBackgroundColor(Color.RED);
				break;
			case 1:
				man.center.setBackgroundColor(Color.GREEN);
				break;
			case 2:
				man.center.setBackgroundColor(Color.YELLOW);
				break;
			case 3:
				man.center.setBackgroundColor(Color.CYAN);
				break;
		}
		
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
	
	

}
