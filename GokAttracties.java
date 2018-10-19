package weekopdracht_extra;

interface GokAttracties {

	default void kansSpelBelastingBetalen(Attractie x) {
		System.out.printf("De belastinginspecteur ontvangt €%.2f van de omzet.\n", x.gereserveerdeOmzet);
		x.aantalbezoekenInspecteur++;

		for (int y = 0; y < Kermis.attracties.length; y++) {
			if (Kermis.attracties[y].equals(x)) {
				x.kassa.setOmzetAttracties(x.kassa.getOmzetAttracties(y, 0) - x.gereserveerdeOmzet, y, 0);
				x.kassa.setOmzetAttracties(x.kassa.getOmzetAttracties(y, 1) + x.gereserveerdeOmzet, y, 1);
			}
		}
		x.gereserveerdeOmzet = 0.00;
	}
}