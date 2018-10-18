package weekopdracht_extra;

abstract public class Attractie {
	Attractie attractie;
	String attractienaam;
	int oppervlakte, aantalkaartjes, index;
	Double prijs, omzet = 0.00, gereserveerdeOmzet = 0.00;
	Kassa kassa = new Kassa();

	void draaien() {
		System.out.println("De attractie " + attractienaam + " draait.");
	}

	void vulKassa(int attractieKeuze) {
		kassa.addToOmzetAttractie(attractieKeuze, prijs);
	}

	void verhoogKaartAantal() {
		aantalkaartjes++;
		//System.out.println("Het aantal verkochte kaartjes (" + attractienaam + ") is " + aantalkaartjes + ".");
	}
}

class Botsauto extends Attractie {
	Botsauto() {
		attractienaam = "Botsauto's";
		prijs = 2.50;
	}
}

class Spin extends RisicoRijkeAttracties {
	Spin() {
		attractienaam = "Spin";
		prijs = 2.25;
		draaiLimiet = 5;
	}
}

class Spiegelpaleis extends Attractie {
	Spiegelpaleis() {
		attractienaam = "Spiegelpaleis";
		prijs = 2.75;
	}
}

class Spookhuis extends Attractie {
	Spookhuis() {
		attractienaam = "Spookhuis";
		prijs = 3.20;
	}
}

class Hawaii extends RisicoRijkeAttracties {
	Hawaii() {
		attractienaam = "Hawaii";
		prijs = 2.90;
		draaiLimiet = 10;
	}
}

class Ladderklimmen extends Attractie implements GokAttracties {
	Ladderklimmen() {
		attractienaam = "Ladderklimmen";
		prijs = 5.00;
		gereserveerdeOmzet = prijs * 0.3;
	}

	public void kansSpelBelastingBetalen() {
		System.out.printf("Er wordt %.2f gereserveerd van de prijs. In totaal is er %.2f gereserveerd van de omzet.\n",
				gereserveerdeOmzet, 0.3 * omzet);
		Main.pressEnter();
	}
}