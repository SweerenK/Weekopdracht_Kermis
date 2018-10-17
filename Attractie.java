package weekopdracht_extra;

abstract public class Attractie {
	Attractie attractie;
	String attractienaam;
	int oppervlakte, aantalkaartjes, index;
	Double prijs, omzet;
	Kassa kassa = new Kassa();

	void draaien() {
		System.out.println("De attractie " + attractienaam + " draait.");
	}

	void vulKassa(int attractieKeuze) {
		kassa.addToOmzetAttractie(attractieKeuze, prijs);
		System.out.println(kassa.omzetAttracties[attractieKeuze]);
	}

	void verhoogKaartAantal() {
		aantalkaartjes++;
		System.out.println("Het aantal verkochte kaartjes (" + attractienaam + ") is " + aantalkaartjes + ".");
	}
}

class Botsauto extends Attractie {
	Botsauto() {
		attractienaam = "Botsauto's";
		prijs = 2.50;
		aantalkaartjes = 0;
	}
}

class Spin extends Attractie {
	Spin() {
		attractienaam = "Spin";
		prijs = 2.25;
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

class Hawaii extends Attractie {
	Hawaii() {
		attractienaam = "Hawaii";
		prijs = 2.90;
	}
}

class Ladderklimmen extends Attractie {
	Ladderklimmen() {
		attractienaam = "Ladderklimmen";
		prijs = 5.00;
	}
}