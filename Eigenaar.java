package weekopdracht_extra;

public class Eigenaar {
	int[] aantalVerkochteKaartjes = new int[6];
	String[] vragenAanBezoeker = { "Wil je een nieuwe rit maken?", "Wil je inzage in de cijfers?",
			"Wil je de kermis verlaten?" };
	String[][] cijfersVoorBezoeker = { { "k", "aantal kaartjes" }, { "o", "omzet attracties" },{"t", "terug.."} };

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
		nieuweAttractie.draaien();
		nieuweAttractie.vulKassa(attractieKeuze - 1); //
		nieuweAttractie.verhoogKaartAantal();
		setAantalVerkochteKaartjes();

		System.out.println("Het totaal aantal verkochte kaartjes is " + getAantalVerkochteKaartjes() + ".");
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
			System.out.println("Oh je gaat weer? Nouja.. tot de volgende keer!");
			Main.kermisverlaten = true;
			break;
		default:
			System.out.println("Sorry, ik hoorde je antwoord niet.");
			geefInzageInCijfers();
		}
	}

	void toonCijfersOmzet() {
		Kassa kassa = new Kassa();
		System.out.println("Omzet\tAttractie");
		for(int k = 0; k< Kermis.attracties.length ; k++) {
			System.out.println(kassa.omzetAttracties[k] + "\t" + Kermis.attracties[k].attractienaam);
		}
		System.out.println();
		geefInzageInCijfers();
	}

	void toonCijfersKaartverkoop() {

	}

}
