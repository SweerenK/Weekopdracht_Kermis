package weekopdracht_extra;

import java.util.Random;

public class BelastingInspecteur {
	Random randomBezoek = new Random();
	Kassa kassa = new Kassa();
	private int totaalAantalRittenGeind = 0;
	
	void checkAttractie(Attractie x) {
		if (x instanceof GokAttracties) {
			x.reserveerOmzet();
			if (x.bezoekMoment == 0) {
				((GokAttracties) x).kansSpelBelastingBetalen(x);
				setBezoekMoment(x);
			} else if (x.bezoekMoment == x.aantalkaartjes - totaalAantalRittenGeind) {
				((GokAttracties) x).kansSpelBelastingBetalen(x);
				totaalAantalRittenGeind += x.bezoekMoment;
				setBezoekMoment(x);
			} else {	
			}
		}
	}

	void setBezoekMoment(Attractie x) {
		x.bezoekMoment = 1 + randomBezoek.nextInt(15);
		System.out.println("De belastinginspecteur zegt: \"Ik kom langs na " + x.bezoekMoment + " rit(ten) van deze attractie.\"");
		Main.pressEnter();
	}

	int getBezoekMoment(Attractie x) {
		return x.bezoekMoment;
	}
}