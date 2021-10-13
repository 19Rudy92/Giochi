package model;

public class Guerriero {

	private String specie;
	private int vita;
	private int velocita;
	private int agilita;
	private int attacco;
	private int difesa;

	public Guerriero(String specie, int vita, int velocita, int agilita, int attacco, int difesa) {
		super();
		this.specie = specie;
		this.vita = vita;
		this.velocita = velocita;
		this.agilita = agilita;
		this.attacco = attacco;
		this.difesa = difesa;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getVelocita() {
		return velocita;
	}

	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}

	public int getAgilita() {
		return agilita;
	}

	public void setAgilita(int agilita) {
		this.agilita = agilita;
	}

	public int getAttacco() {
		return attacco;
	}

	public void setAttacco(int attacco) {
		this.attacco = attacco;
	}

	public int getDifesa() {
		return difesa;
	}

	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}

	@Override
	public String toString() {
		return "Guerriero [specie=" + specie + ", vita=" + vita + ", velocita=" + velocita + ", agilita=" + agilita
				+ ", attacco=" + attacco + ", difesa=" + difesa + "]";
	}

}
