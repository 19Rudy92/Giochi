package view;

import java.io.File;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class View implements IView {

	private String templatePath;												//Assegnamo un path per il template

	public View(String templatePath) {
		this.templatePath = templatePath;
	}

	public String loadTemplate(String file) {									//Metodo per caricare i template
		String res = "";
		try {
			Scanner console = new Scanner(new File(templatePath + file));		//Carichiamo il file con lo scanner
			while (console.hasNextLine()) {										//Attraverso il ciclo 
				res += console.nextLine() + "\n";
			}
		} catch (Exception e) {
			e.printStackTrace();												//Stampa l'errore in caso non trovasse il file

		}

		return res;
	}

	@Override
	public String renderArena(String razzaPlayer, String razzaNemico) {
		return loadTemplate("Arena.txt").replace("[RAZZAP]", razzaPlayer).		//Diciamo quale file sarà caricato, e al suo interno ci sarà scritto, razza giocatore, e razza nemico
				replace("[RAZZAN]", razzaNemico);
	}

	@Override
	public String renderComb(int vitaPlayer, int vitaNemico) {
		return loadTemplate("Comb.txt").replace("[VITAP]",vitaPlayer+"").replace("[VITAN]", vitaNemico+"");
	}

	@Override
	public String renderAttc(int attacco) {
		return loadTemplate("Attc.txt").replace("[ATTC]", attacco+"");
	}

	@Override
	public String renderEsitoComb(String razza, int attacco) {
		return loadTemplate("EsitoComb.txt").replace("[RAZZA]", razza).replace("[ATTC]", attacco+"");
	}

	@Override
	public String renderVitaRest(String razza, int vita) {
		return loadTemplate("VitaRest.txt").replace("[RAZZA]", razza).replace("[VITA]", vita+"");
	}

	@Override
	public String renderAttcFall(String razza) {
		return loadTemplate("AttcFall.txt").replace("[RAZZA]", razza);
	}

	@Override
	public String renderFine(String esito) {
		return loadTemplate("Fine.txt").replace("[ESITO]", esito);
	}

}
