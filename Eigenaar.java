package weekopdracht_extra;

public class Eigenaar {
	int[] aantalVerkochteKaartjes = new int[6];
	String[] vragenAanBezoeker = { "Wil je een nieuwe rit maken?", "Wil je inzage in de cijfers?",
			"Wil je de kermis verlaten?" };
	String[][] cijfersVoorBezoeker = { { "k", "aantal kaartjes" }, { "o", "omzet attracties" },{"t", "terug.."} };
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

	void verwerkAttractieKeuze(int attractieKeuze) {
		Attractie nieuweAttractie = Kermis.attracties[attractieKeuze - 1];
		if(nieuweAttractie instanceof RisicoRijkeAttracties) {
			RisicoRijkeAttracties riskAttractie = (RisicoRijkeAttracties)nieuweAttractie;
			if(riskAttractie.opstellingsKeuring(nieuweAttractie.aantalkaartjes)) {
				System.out.println("De attractie wordt gekeurd.");
				Main.pressEnter();
			}
		}
		nieuweAttractie.draaien();
		nieuweAttractie.vulKassa(attractieKeuze - 1); //
		nieuweAttractie.verhoogKaartAantal();
	
		setAantalVerkochteKaartjes();
		//System.out.println("Het totaal aantal verkochte kaartjes is " + getAantalVerkochteKaartjes() + ".");
		if(nieuweAttractie instanceof GokAttracties) {
			((GokAttracties) nieuweAttractie).kansSpelBelastingBetalen();
		}
	}

	void stelVragenAanBezoeker() {
		for (int i = 0; i < vragenAanBezoeker.length; i++) {
			System.out.println((i + 1) + ".\t" + vragenAanBezoeker[i]);
		}
		
		switch (Main.scan.nextInt()) {
		case 1:
			break;
		case 2:
			geefInzageInCijfers();
			break;
		case 3:
			Main.kermisverlaten = true;
			break;
		default:
			System.out.println("Sorry, ik hoorde je antwoord niet.");
			stelVragenAanBezoeker();
		}
	}

	void geefInzageInCijfers() {
		System.out.println("Welke informatie wil je weten?");
		for (int j = 0; j < cijfersVoorBezoeker.length; j++) {
			System.out.println(cijfersVoorBezoeker[j][0] + ".\t" + cijfersVoorBezoeker[j][1]);
		}

		String antwoord = Main.scan.nextLine();

		switch (antwoord) {
		case "k":
			toonCijfersKaartverkoop();
			break;
		case "o":
			toonCijfersOmzet();
			break;
		case "t":
			stelVragenAanBezoeker();
			break;
		case "quit":
			System.out.println("Tot de volgende keer!");
			Main.kermisverlaten = true;
			break;
		default:
			System.out.println("Sorry, ik hoorde je antwoord niet.");
			geefInzageInCijfers();
		}
	}

	void toonCijfersOmzet() {
		Double totaleOmzet = 0.00;
		System.out.println("OMZET\tATTRACTIE");
		for(int k = 0; k< Kermis.attracties.length ; k++) {
			System.out.printf("%.2f\t%s\n", Kermis.attracties[k].omzet, Kermis.attracties[k].attractienaam);
			totaleOmzet += Kermis.attracties[k].omzet;
		}
		System.out.printf("----\n%.2f\t%s\n", totaleOmzet, "Totaal");
		
		System.out.println();
		geefInzageInCijfers();
	}

	void toonCijfersKaartverkoop() {
		System.out.println("AANTAL\tATTRACTIE");
		for(int k = 0; k< Kermis.attracties.length ; k++) {
			System.out.println(Kermis.attracties[k].aantalkaartjes + "\t" + Kermis.attracties[k].attractienaam);
		}
		System.out.println("----\n" + getAantalVerkochteKaartjes() + "\tTotaal");
		System.out.println();
		geefInzageInCijfers();
	}
}
