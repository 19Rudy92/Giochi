package view;

public interface IView {
	
	public String renderArena(String razzaPlayer, String razzaNemio);	//Arena combattimento con le razze in gioco
	
	public String renderComb(int vitaP, int vitaN);						//Punti vita personaggi
	
	public String renderAttc(int attacco);								//Reindirizza l'attacco
	
	public String renderEsitoComb(String razza, int attacco);			//Esito combattimento

	public String renderVitaRest(String razza, int vita);				//Vita restante
	
	public String renderAttcFall(String razza);							//Se attacco non supera difesa nemico, fallisce

	public String renderFine(String esito);
	
}
