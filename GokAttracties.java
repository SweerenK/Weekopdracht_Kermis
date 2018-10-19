package weekopdracht_extra;

interface GokAttracties {

	default void kansSpelBelastingBetalen(Attractie x) {
		System.out.printf("De belastinginspecteur ontvangt €%.2f van de omzet.\n", x.gereserveerdeOmzet);
		x.aantalbezoekenInspecteur++;

		for (int y = 0; y < Kermis.attracties.length; y++) {
			if (Kermis.attracties[y].equals(x)) {
				x.kassa.omzetAttracties[y][0] -= x.gereserveerdeOmzet;
				x.kassa.omzetAttracties[y][1] += x.gereserveerdeOmzet;

				System.out.println(x.kassa.omzetAttracties[y][0] + "<>" + x.kassa.omzetAttracties[y][1]);
			}
		}
		x.gereserveerdeOmzet = 0.00;
	}
}