package model;

import java.util.Random;

public class Combat implements ICombat {

	@Override
	public int attacco(Guerriero g) {
		int attacco = g.getAttacco() + g.getAgilita();
		Random dado = new Random(); // Numero random per aggiungerlo all attacco
		int numMagico = dado.nextInt(100); // Il numero puo andare da 0 a 100
		attacco += numMagico; // L attacco verra incrementato dal numUscito
		return attacco;
	}

//Lo stesso lo facciamo per le altre "qualita" del guerriero

	@Override
	public int difesa(Guerriero g) {
		int difesa = g.getDifesa() + g.getAgilita();
		Random dado = new Random();
		int numUscito = dado.nextInt(100);
		difesa += numUscito;
		return difesa;
	}

	@Override
	public int velocita(Guerriero g) {
		int velocita = g.getVelocita();
		Random dado = new Random();
		int numUscito = dado.nextInt(100);
		velocita += numUscito;
		return velocita;
	}

	

}
