package weekopdracht_extra;

public class Monteur {

	void onderhoudAttracties() {
		System.out.println(
				"Monteur: \"Ik zal de RisicoRijkeAttracties keuren, voordat ze gebruikt worden.\nLaten we ook gelijk een nieuwe afspraak inplannen:\"\n");
		System.out.println("ATTRACTIE\tNIEUWE AFSPRAAK");
		for (int i = 0; i < Kermis.attracties.length; i++) {
			if ((Kermis.attracties[i] instanceof RisicoRijkeAttracties)) {
				Attractie attractie = Kermis.attracties[i];
				RisicoRijkeAttracties risicoAttractie = (RisicoRijkeAttracties) attractie;
				risicoAttractie.vervroegdeKeuring = (risicoAttractie.aantalkaartjes % risicoAttractie.draaiLimiet);
				System.out.println(attractie.attractienaam + "\t\t" + "na " + risicoAttractie.draaiLimiet + " keer");
			}
		}

		System.out.println("\nMocht je de attracties eerder willen laten keuren, dan weet je mij te vinden!");
		Main.pressEnter();
	}
}