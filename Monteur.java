package weekopdracht_extra;

public class Monteur {

	void onderhoudAttracties() {
		System.out.println(
				"Monteur: \"Ik zal de RisicoRijkeAttracties keuren, voordat ze de volgende keer gebruikt worden.\nLaten we ook alvast een nieuwe afspraak inplannen:\"\n");
		System.out.println("ATTRACTIE\tNIEUWE AFSPRAAK");
		for (int i = 0; i < Kermis.attracties.length; i++) {
			if ((Kermis.attracties[i] instanceof RisicoRijkeAttracties)) {
				Attractie attractie = Kermis.attracties[i];
				RisicoRijkeAttracties risicoAttractie = (RisicoRijkeAttracties) attractie;
				risicoAttractie.vervroegdeKeuring = (risicoAttractie.aantalkaartjes % risicoAttractie.draaiLimiet);
				System.out.println(attractie.attractienaam + "\t\t" + "na " + risicoAttractie.draaiLimiet + " keer");
			}
		}

		System.out.print("\n\"Mocht je de attracties eerder willen laten keuren, dan weet je mij te vinden!\"\t");
		Main.pressEnter();
	}
}