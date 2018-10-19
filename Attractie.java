package weekopdracht_extra;

abstract public class Attractie {
	Attractie attractie;
	String attractienaam;
	int aantalkaartjes, index, aantalbezoekenInspecteur, bezoekMoment = 0, vervroegdeKeuring = 0;
	Double prijs, omzet = 0.00, gereserveerdeOmzet = 0.00, afgedragenOmzet = 0.00;
	Kassa kassa = new Kassa();

	void draaien() {
		System.out.println("De attractie " + attractienaam + " draait.");
	}

	void vulKassa(int attractieKeuze) {
		kassa.addToOmzetAttractie(attractieKeuze, prijs);
	}

	void verhoogKaartAantal() {
		aantalkaartjes++;
	}
	
	void reserveerOmzet() {
		gereserveerdeOmzet+=0.3*prijs;
	}
}

class Botsauto extends Attractie {
	Botsauto() {
		attractienaam = "Botsauto's";
		prijs = 2.50;
	}
}

class Spin extends RisicoRijkeAttracties implements GokAttracties{
	Spin(){
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
	}
}