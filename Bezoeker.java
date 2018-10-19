package weekopdracht_extra;

public class Bezoeker {
	Double bedragOpZak = 0.00;
	Kermis kermis = new Kermis();

	int kiesAttractie() {
		while (Main.kermisverlaten == false) {
			System.out.printf("Je hebt €" + "%.2f" + "\n", bedragOpZak);
			System.out.println("De eigenaar vraagt: \"In welke attractie wil je?\"");
			for (int i = 0; i < kermis.attracties.length; i++) {
				if (i == 3) {
					System.out.println();
				}
				System.out.printf((i + 1) + ". " + kermis.attracties[i].attractienaam + " (€" + "%.2f" + ")  \t\t",
						kermis.attracties[i].prijs);
			}
			int keuze = Main.scan.nextInt();
			Main.scan.nextLine();
			return keuze;
		}
		return -1;
	}

	void betaalVoorAttractie(Double prijs) {
		bedragOpZak -= prijs;
	}

	void setBedragOpZak(Double geld) {
		bedragOpZak += geld;
	}

	boolean controleerPortemonnee(int attractieKeuze, Double goedkoopsteAttractie) {
		if (attractieKeuze != -1 && bedragOpZak > Kermis.attracties[attractieKeuze - 1].prijs) {
			betaalVoorAttractie(Kermis.attracties[attractieKeuze - 1].prijs);
			return true;
		} else if ((bedragOpZak > goedkoopsteAttractie) && Main.kermisverlaten != true) {
			System.out.println("Eigenaar: \"Je hebt niet genoeg geld om in deze attractie te gaan.\"");
			return false;
		} else if (Main.kermisverlaten != true) {
			System.out.println("Je hebt onvoldoende geld om in een attractie te gaan.");
			return false;
		} else {
			return false;
		}
	}
}
