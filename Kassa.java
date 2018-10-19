package weekopdracht_extra;

public class Kassa {
	private Double omzetBotsauto, omzetSpin, omzetSpiegelpaleis, omzetSpookhuis, omzetHawaii, omzetLadderklimmen;
	private Double omzetBotsautoGeind, omzetSpinGeind, omzetSpiegelpaleisGeind, omzetSpookhuisGeind, omzetHawaiiGeind,
			omzetLadderklimmenGeind;
	private Double[][] omzetAttracties = { { omzetBotsauto = 0.00, omzetBotsautoGeind = 0.00 },
			{ omzetSpin = 0.00, omzetSpinGeind = 0.00 }, { omzetSpiegelpaleis = 0.00, omzetSpiegelpaleisGeind = 0.00 },
			{ omzetSpookhuis = 0.00, omzetSpookhuisGeind = 0.00 }, { omzetHawaii = 0.00, omzetHawaiiGeind = 0.00 },
			{ omzetLadderklimmen = 0.00, omzetLadderklimmenGeind = 0.00 } };
	private int[] aantalBezoekenInspecteur = { 0, 0, 0, 0, 0, 0 };

	public void addToOmzetAttractie(int attractieKeuze, Double prijs) {
		for (int j = 0; j < Kermis.attracties.length; j++) {
			if (j == attractieKeuze) {
				Kermis.attracties[j].omzet += prijs;
				omzetAttracties[j][0] += prijs;
			}
		}
	}
	
	Double getOmzetAttracties(int r, int c) {
		return omzetAttracties[r][c];
	}
	
	void setOmzetAttracties(Double value, int r, int c) {
		omzetAttracties[r][c] = value;
	}
}
