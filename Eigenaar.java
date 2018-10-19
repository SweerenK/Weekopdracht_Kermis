package weekopdracht_extra;

import java.util.Scanner;

public class Eigenaar {
	int[] aantalVerkochteKaartjes = new int[6];
	String[] vragenAanBezoeker = { "\"Wil je een nieuwe rit maken?\"", "\"Wil je naar de pinautomaat?\"",
			"\"Zal ik inzage in de cijfers geven?\"", "\"Zal ik de monteur langs laten komen?\"",
			"\"Wil je de kermis verlaten?\"" };
	String[][] cijfersVoorBezoeker = { { "k", "aantal kaartjes" }, { "o", "omzet attracties" }, { "t", "terug.." } };
	Kassa kassa = new Kassa();

	public void setAantalVerkochteKaartjes() {
		for (int k = 0; k < aantalVerkochteKaartjes.length; k++) {
			aantalVerkochteKaartjes[k] = Kermis.attracties[k].aantalkaartjes;
		}
	}

	int getAantalVerkochteKaartjes() {
		int totaal = 0;
		for (int l = 0; l < aantalVerkochteKaartjes.length; l++) {
			totaal += aantalVerkochteKaartjes[l];
		}
		return totaal;
	}

	void verwerkAttractieKeuze(int attractieKeuze, BelastingInspecteur inspectie) {
		Attractie nieuweAttractie = Kermis.attracties[attractieKeuze - 1];

		if (nieuweAttractie instanceof RisicoRijkeAttracties) {
			RisicoRijkeAttracties riskAttractie = (RisicoRijkeAttracties) nieuweAttractie;
			if (riskAttractie.opstellingsKeuring(nieuweAttractie.aantalkaartjes, nieuweAttractie.vervroegdeKeuring)) {
				System.out.print("\nDe attractie wordt gekeurd.");
				Main.pressEnter();
			}
		}

		nieuweAttractie.draaien();
		nieuweAttractie.vulKassa(attractieKeuze - 1);
		inspectie.checkAttractie(nieuweAttractie);
		nieuweAttractie.verhoogKaartAantal();
		setAantalVerkochteKaartjes();
	}

	void stelVragenAanBezoeker(Bezoeker bezoeker) {
		System.out.println("De eigenaar vraagt: ");
		for (int i = 0; i < vragenAanBezoeker.length; i++) {
			System.out.println((i + 1) + ".\t" + vragenAanBezoeker[i]);
		}
		int keuze = Main.scan.nextInt();
		Main.scan.nextLine();
		switch (keuze) {
		case 1:
			break;
		case 2:
			System.out.printf("Je hebt €" + "%.2f" + " op zak.\nHoeveel geld wil je pinnen?", bezoeker.bedragOpZak);
			Double geld = Main.scan.nextDouble();
			Main.scan.nextLine();
			try {
				if (geld > 0) {
					bezoeker.setBedragOpZak(geld);
					System.out.printf("Je hebt €" + "%.2f" + " gepind.", geld);
				} else {
					System.out.println("Je kunt geen negatief bedrag pinnen.");
				}
			} catch (Exception e) {
				System.out.println("Je hebt geprobeerd een onjuist bedrag te pinnen.\nBedragen zijn kommagetallen.");
			}
			Main.pressEnter();
			stelVragenAanBezoeker(bezoeker);
			break;
		case 3:
			geefInzageInCijfers(bezoeker);
			break;
		case 4:
			Monteur monteur = new Monteur();
			monteur.onderhoudAttracties();
			stelVragenAanBezoeker(bezoeker);
			break;
		case 5:
			Main.kermisverlaten = true;
			break;
		default:
			System.out.println("\"Sorry, ik hoorde je antwoord niet.\"");
			stelVragenAanBezoeker(bezoeker);
		}
	}

	void geefInzageInCijfers(Bezoeker bezoeker) {
		System.out.println("De eigenaar vraagt: \"Welke informatie wil je weten?\"");
		for (int j = 0; j < cijfersVoorBezoeker.length; j++) {
			System.out.println(cijfersVoorBezoeker[j][0] + ".\t" + cijfersVoorBezoeker[j][1]);
		}

		switch (Main.scan.nextLine()) {
		case "k":
			toonCijfersKaartverkoop();
			Main.pressEnter();
			geefInzageInCijfers(bezoeker);
			break;
		case "o":
			toonCijfersOmzet();
			Main.pressEnter();
			geefInzageInCijfers(bezoeker);
			break;
		case "t":
			stelVragenAanBezoeker(bezoeker);
			break;
		case "quit":
			Main.kermisverlaten = true;
			break;
		default:
			System.out.println("Sorry, ik hoorde je antwoord niet.");
			geefInzageInCijfers(bezoeker);
		}
	}

	void toonCijfersOmzet() {
		Double totaleOmzet = 0.00, totaleAfdracht = 0.00;
		System.out.printf("%s\t%s\t%s\n", "ATTRACTIE", "OMZET", "AFDRACHT");
		for (int k = 0; k < Kermis.attracties.length; k++) {
			if (Kermis.attracties[k].attractienaam.length() > 6) {
				System.out.printf("%s\t%.2f\t%.2f (%s)\n", Kermis.attracties[k].attractienaam,
						Kermis.attracties[k].omzet, Kermis.attracties[k].kassa.omzetAttracties[k][1],
						Kermis.attracties[k].aantalbezoekenInspecteur);
			} else {
				System.out.printf("%s\t\t%.2f\t%.2f (%s)\n", Kermis.attracties[k].attractienaam,
						Kermis.attracties[k].omzet, Kermis.attracties[k].kassa.omzetAttracties[k][1],
						Kermis.attracties[k].aantalbezoekenInspecteur);
			}
			totaleOmzet += Kermis.attracties[k].omzet;
			totaleAfdracht += Kermis.attracties[k].kassa.omzetAttracties[k][1];
		}
		System.out.printf("-------------\n%s\t\t%.2f\t%.2f\n", "Totaal", totaleOmzet, totaleAfdracht);
		System.out.println();
	}

	void toonCijfersKaartverkoop() {
		System.out.println("AANTAL\tATTRACTIE");
		for (int k = 0; k < Kermis.attracties.length; k++) {
			System.out.println(Kermis.attracties[k].aantalkaartjes + "\t" + Kermis.attracties[k].attractienaam);
		}
		System.out.println("----\n" + getAantalVerkochteKaartjes() + "\tTotaal\n");
		System.out.println();
	}
}