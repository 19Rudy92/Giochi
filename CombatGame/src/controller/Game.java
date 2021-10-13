package controller;

import java.util.Random;
import java.util.Scanner;

import model.Combat;
import model.Guerriero;
import model.ICombat;
import view.IView;
import view.View;

public class Game {

	public static void main(String[] args) throws InterruptedException {

		Guerriero orco = new Guerriero("Orco", 300, 50, 40, 80, 80);

		Guerriero umano = new Guerriero("Umano", 300, 80, 80, 60, 70);

		Guerriero elfo = new Guerriero("Elfo", 300, 90, 90, 50, 60);

		Guerriero scheletro = new Guerriero("Scheletro", 300, 40, 30, 90, 90);

		Guerriero valchiria = new Guerriero("Valchiria", 300, 80, 80, 70, 60);

		Guerriero goblin = new Guerriero("Goblin", 300, 30, 30, 60, 80);

		ICombat c = new Combat();

		IView view = new View("C:\\Users\\Martella Rudy\\Documents\\WorkSpace_sts\\CombatGame\\src\\templates/");

		Scanner tastiera = new Scanner(System.in);

		String cmd = ""; // Instanziamo il comando

		String response = ""; // Instanziamo la risponsta

		do {
			System.out.println("Inserire comando: ");

			cmd = tastiera.nextLine();

			switch (cmd) {
			case "combattimento":
				response = "Inizia il combattimento";
				break;

			case "aiuto":
				response = "Scrivere combattimento per combattere, esci per uscire: ";
				break;

			case "esci":
				response = "Ti ringraziamo per il tuo coraggio";
				break;

			default:
				response = "comando errato, digita aiuto se ne hai bisogno";
			}

			System.out.println(response);

			if (cmd.equalsIgnoreCase("combattimento")) {
				System.out.println("Scegli il personaggio");

				String razza = tastiera.nextLine();

				Guerriero player = null;

				Guerriero nemico = null;

				switch (razza) {

				case "orco":
					player = orco;
					break;

				case "umano":
					player = umano;
					break;

				case "elfo":
					player = elfo;

				case "scheletro":
					player = scheletro;
					break;

				case "valchiria":
					player = valchiria;
					break;

				case "goblin":
					player = goblin;
					break;

				case "aiuto":
					System.out.println(
							"Scegli una delle seguenti razze: orco, umano, elfo, scheletro, valchiria, goblin");
					break;

				default:
					System.out.println("razza non disponibile");
				}

				Random dado = new Random();
				int numeroNemico = dado.nextInt(6);
				switch (numeroNemico) {
				case 1:
					nemico = orco;
					break;

				case 2:
					nemico = umano;
					break;

				case 3:
					nemico = elfo;
					break;

				case 4:
					nemico = scheletro;
					break;

				case 5:
					nemico = valchiria;
					break;

				case 6:
					nemico = goblin;
					break;

				}

				System.out.println(view.renderArena(player.getSpecie(), nemico.getSpecie()));

				int vitaPlayer = player.getVita();

				int vitaNemico = nemico.getVita();

				while (vitaPlayer > 0 && vitaNemico > 0) {
					System.out.println(view.renderComb(vitaPlayer, vitaNemico));

					if (c.velocita(player) > c.velocita(nemico)) {
						int attc = c.attacco(player) - c.difesa(nemico);

						view.renderAttc(attc);

						if (attc > 0) {

							vitaNemico = vitaNemico - attc;

							System.out.println(view.renderEsitoComb(player.getSpecie(), attc));
							System.out.println(view.renderVitaRest(nemico.getSpecie(), vitaNemico));

						} else {
							view.renderAttcFall(player.getSpecie());
						}
					} else if (c.velocita(nemico) > c.velocita(player)) {
						int attc = c.attacco(nemico) - c.difesa(player);

						view.renderAttc(attc);

						if (attc > 0) {

							vitaPlayer = vitaPlayer - attc;

							System.out.println(view.renderEsitoComb(nemico.getSpecie(), attc));
							System.out.println(view.renderEsitoComb(player.getSpecie(), vitaPlayer));

						} else {
							view.renderAttcFall(nemico.getSpecie());
						}
					}

					else {
						System.out.println("Colpi falliti");
					}
					Thread.sleep(2000);

				}

				if (vitaPlayer >= 0) {
					System.out.println(view.renderFine("You win"));
				} else {
					System.out.println(view.renderFine("You lose"));

				}

			}

		} while (!cmd.equalsIgnoreCase("Esci"));
	}

}
