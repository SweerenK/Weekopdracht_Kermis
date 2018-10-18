package weekopdracht_extra;

public class Kassa {
	Double omzetBotsauto = 0.00, omzetSpin = 0.00, omzetSpiegelpaleis = 0.00, omzetSpookhuis = 0.00, omzetHawaii = 0.00,
			omzetLadderklimmen = 0.00;
	Double[] omzetAttracties = { omzetBotsauto, omzetSpin, omzetSpiegelpaleis, omzetSpookhuis, omzetHawaii,
			omzetLadderklimmen };

	public void addToOmzetAttractie(int attractieKeuze, Double prijs) {
		for (int j = 0; j < Kermis.attracties.length; j++) {
			if (j == attractieKeuze) {
				Kermis.attracties[j].omzet += prijs;
			}
		}
	}

}
